package com.myself.mykotlin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.myself.mykotlin.db.dao.DaoMaster;
import com.myself.mykotlin.db.dbmanager.CityDBManager;
import com.myself.mykotlin.db.dbmanager.CompanionDBManager;
import com.myself.mykotlin.db.dbmanager.DataBaseManager;
import com.myself.mykotlin.db.dbmanager.DistrictDBManager;
import com.myself.mykotlin.db.dbmanager.MessageDBMangaer;
import com.myself.mykotlin.db.dbmanager.PaibandDBManager;
import com.myself.mykotlin.db.dbmanager.ProvinceDBManager;
import com.myself.mykotlin.db.dbmanager.TemplateDBManager;
import com.myself.mykotlin.http.OkHttpManager;
import com.myself.mykotlin.http.interceptor.CacheStrategyInterceptor;
import com.myself.mykotlin.http.interceptor.HeaderInfoInterceptor;
import com.myself.mykotlin.http.interceptor.NetworkInterceptor;
import com.myself.mykotlin.http.interceptor.ResponseInfoInterceptor;
import com.myself.mykotlin.utils.AppUtils;
import com.myself.mykotlin.utils.Logger;
import com.myself.mykotlin.utils.SDCardUtils;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsListener;

import java.io.File;

import butterknife.ButterKnife;
import okhttp3.OkHttpClient;

import static android.os.Process.killProcess;


/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Email      : jusenr@163.com
 * Company    : 葡萄科技
 * Author     : Jusenr
 * Date       : 2016/12/27 16:05.
 */

public class TotalApplication extends MultiDexApplication {
    private static Context mContext;
    private static String TBS_APPKEY = "RbTRgDw6r5KTBOQr3ME8vIxU";
    private static OkHttpClient mOkHttpClient;
    public static String sdCardPath;//SdCard路径
    private static DaoMaster.OpenHelper mHelper;
    private boolean isDebug;

    /**
     * 网络环境切换
     *
     * @return
     */
    protected boolean configEnvironment() {

        return false;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        isDebug = configEnvironment();
        //sdCard缓存路径
        sdCardPath = getSdCardPath();
        //安装数据库
        installDataBase();
        //ButterKnife的Debug模式
        ButterKnife.setDebug(isDebug);
        //OkHttp初始化
//        mOkHttpClient = new OkHttpClient();
        mOkHttpClient = OkHttpManager.getInstance(getNetworkCacheDirectoryPath(), getNetworkCacheSize())
                .addInterceptor(new NetworkInterceptor())
                .addInterceptor(new ResponseInfoInterceptor())
                .addInterceptor(new CacheStrategyInterceptor())
                .addInterceptor(new HeaderInfoInterceptor(AppUtils.getVersionName(mContext)))
                .build();
        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        //TbsDownloader.needDownload(getApplicationContext(), false);
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
            @Override
            public void onViewInitFinished(boolean arg0) {
                // TODO Auto-generated method stub
                Log.e("app", " onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
                // TODO Auto-generated method stub
            }
        };
        QbSdk.setTbsListener(new TbsListener() {
            @Override
            public void onDownloadFinish(int i) {
                Log.d("app", "onDownloadFinish");
            }

            @Override
            public void onInstallFinish(int i) {
                Log.d("app", "onInstallFinish");
            }

            @Override
            public void onDownloadProgress(int i) {
                Log.d("app", "onDownloadProgress:" + i);
            }
        });
        QbSdk.initX5Environment(getApplicationContext(), cb);
    }

    public static Context getInstance() {
        return mContext;
    }

    public static OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }

    public String getPackageName() {
        return "com.myself.mykotlin";
    }

    /**************************************************************************/

    protected String getLogTag() {
        return "my-kotlin";
    }

    protected String getSdCardPath() {
        return SDCardUtils.getSDCardPath() + File.separator + getLogTag();
    }

    protected String getNetworkCacheDirectoryPath() {
        return sdCardPath + File.separator + "http_cache";
    }

    protected int getNetworkCacheSize() {
        return 20 * 1024 * 1024;
    }

    protected int getNetworkCacheMaxAgeTime() {
        return 0;
    }

    /**
     * 获取DataBaseManager
     *
     * @param clazz 类型
     * @return DataBaseManager实例
     */
    public static DataBaseManager getDataBaseManager(Class<? extends DataBaseManager> clazz) {
        switch (clazz.getSimpleName()) {
            case "CityDBManager":
                return CityDBManager.getInstance(mHelper);
            case "DistrictDBManager":
                return DistrictDBManager.getInstance(mHelper);
            case "ProvinceDBManager":
                return ProvinceDBManager.getInstance(mHelper);
            case "CompanionDBManager":
                return CompanionDBManager.getInstance(mHelper);
            case "TemplateDBManager":
                return TemplateDBManager.getInstance(mHelper);
            case "PaibandDBManager":
                return PaibandDBManager.getInstance(mHelper);
            case "MessageDBMangaer":
                return MessageDBMangaer.getInstance(mHelper);
        }
        return null;
    }

    /**
     * 安装数据库
     */
    private void installDataBase() {
        String DBName = "myself_mykotlin.db";
        //删除旧数据库
        File file = new File(" /data/data/" + AppUtils.getPackageName(this) + "/database/myself_mykotlin.db");
        if (file != null && file.exists()) file.delete();
        if (mHelper == null)
            if (isDebug) {
//                String DBPath = getSdCardPath() + File.separator + DBName;
                mHelper = new DaoMaster.DevOpenHelper(getApplicationContext(), DBName, null);
            } else
                mHelper = new DaoMaster.OpenHelper(getApplicationContext(), DBName, null) {
                    @Override
                    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                        Log.d("database", "oldVersion: " + oldVersion + " newVersion: " + newVersion);
                    }
                };
    }

    /**
     * 捕捉到异常就退出App
     *
     * @param ex 异常信息
     */
    protected void onCrash(Throwable ex) {
        Logger.e("APP崩溃了,错误信息是" + ex.getMessage());
        ex.printStackTrace();

        killProcess(0);
    }

}
