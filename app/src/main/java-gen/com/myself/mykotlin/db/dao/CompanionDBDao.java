package com.myself.mykotlin.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.myself.mykotlin.db.entity.CompanionDB;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "putao_wd_companion".
*/
public class CompanionDBDao extends AbstractDao<CompanionDB, String> {

    public static final String TABLENAME = "putao_wd_companion";

    /**
     * Properties of entity CompanionDB.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, String.class, "id", true, "ID");
        public final static Property Push_id = new Property(1, String.class, "push_id", false, "PUSH_ID");
        public final static Property Service_id = new Property(2, String.class, "service_id", false, "SERVICE_ID");
        public final static Property Type = new Property(3, String.class, "type", false, "TYPE");
        public final static Property Release_time = new Property(4, String.class, "release_time", false, "RELEASE_TIME");
        public final static Property Content_lists = new Property(5, String.class, "content_lists", false, "CONTENT_LISTS");
        public final static Property IsDownload = new Property(6, String.class, "isDownload", false, "IS_DOWNLOAD");
        public final static Property Uid = new Property(7, String.class, "uid", false, "UID");
        public final static Property Key = new Property(8, String.class, "key", false, "KEY");
        public final static Property Message = new Property(9, String.class, "message", false, "MESSAGE");
        public final static Property Image = new Property(10, String.class, "image", false, "IMAGE");
        public final static Property Reply = new Property(11, String.class, "reply", false, "REPLY");
        public final static Property Is_upload_finish = new Property(12, String.class, "is_upload_finish", false, "IS_UPLOAD_FINISH");
        public final static Property Receiver_time = new Property(13, String.class, "receiver_time", false, "RECEIVER_TIME");
        public final static Property Notice = new Property(14, String.class, "notice", false, "NOTICE");
    }


    public CompanionDBDao(DaoConfig config) {
        super(config);
    }
    
    public CompanionDBDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"putao_wd_companion\" (" + //
                "\"ID\" TEXT PRIMARY KEY NOT NULL ," + // 0: id
                "\"PUSH_ID\" TEXT," + // 1: push_id
                "\"SERVICE_ID\" TEXT," + // 2: service_id
                "\"TYPE\" TEXT," + // 3: type
                "\"RELEASE_TIME\" TEXT," + // 4: release_time
                "\"CONTENT_LISTS\" TEXT," + // 5: content_lists
                "\"IS_DOWNLOAD\" TEXT," + // 6: isDownload
                "\"UID\" TEXT," + // 7: uid
                "\"KEY\" TEXT," + // 8: key
                "\"MESSAGE\" TEXT," + // 9: message
                "\"IMAGE\" TEXT," + // 10: image
                "\"REPLY\" TEXT," + // 11: reply
                "\"IS_UPLOAD_FINISH\" TEXT," + // 12: is_upload_finish
                "\"RECEIVER_TIME\" TEXT," + // 13: receiver_time
                "\"NOTICE\" TEXT);"); // 14: notice
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"putao_wd_companion\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, CompanionDB entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        String push_id = entity.getPush_id();
        if (push_id != null) {
            stmt.bindString(2, push_id);
        }
 
        String service_id = entity.getService_id();
        if (service_id != null) {
            stmt.bindString(3, service_id);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(4, type);
        }
 
        String release_time = entity.getRelease_time();
        if (release_time != null) {
            stmt.bindString(5, release_time);
        }
 
        String content_lists = entity.getContent_lists();
        if (content_lists != null) {
            stmt.bindString(6, content_lists);
        }
 
        String isDownload = entity.getIsDownload();
        if (isDownload != null) {
            stmt.bindString(7, isDownload);
        }
 
        String uid = entity.getUid();
        if (uid != null) {
            stmt.bindString(8, uid);
        }
 
        String key = entity.getKey();
        if (key != null) {
            stmt.bindString(9, key);
        }
 
        String message = entity.getMessage();
        if (message != null) {
            stmt.bindString(10, message);
        }
 
        String image = entity.getImage();
        if (image != null) {
            stmt.bindString(11, image);
        }
 
        String reply = entity.getReply();
        if (reply != null) {
            stmt.bindString(12, reply);
        }
 
        String is_upload_finish = entity.getIs_upload_finish();
        if (is_upload_finish != null) {
            stmt.bindString(13, is_upload_finish);
        }
 
        String receiver_time = entity.getReceiver_time();
        if (receiver_time != null) {
            stmt.bindString(14, receiver_time);
        }
 
        String notice = entity.getNotice();
        if (notice != null) {
            stmt.bindString(15, notice);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, CompanionDB entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        String push_id = entity.getPush_id();
        if (push_id != null) {
            stmt.bindString(2, push_id);
        }
 
        String service_id = entity.getService_id();
        if (service_id != null) {
            stmt.bindString(3, service_id);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(4, type);
        }
 
        String release_time = entity.getRelease_time();
        if (release_time != null) {
            stmt.bindString(5, release_time);
        }
 
        String content_lists = entity.getContent_lists();
        if (content_lists != null) {
            stmt.bindString(6, content_lists);
        }
 
        String isDownload = entity.getIsDownload();
        if (isDownload != null) {
            stmt.bindString(7, isDownload);
        }
 
        String uid = entity.getUid();
        if (uid != null) {
            stmt.bindString(8, uid);
        }
 
        String key = entity.getKey();
        if (key != null) {
            stmt.bindString(9, key);
        }
 
        String message = entity.getMessage();
        if (message != null) {
            stmt.bindString(10, message);
        }
 
        String image = entity.getImage();
        if (image != null) {
            stmt.bindString(11, image);
        }
 
        String reply = entity.getReply();
        if (reply != null) {
            stmt.bindString(12, reply);
        }
 
        String is_upload_finish = entity.getIs_upload_finish();
        if (is_upload_finish != null) {
            stmt.bindString(13, is_upload_finish);
        }
 
        String receiver_time = entity.getReceiver_time();
        if (receiver_time != null) {
            stmt.bindString(14, receiver_time);
        }
 
        String notice = entity.getNotice();
        if (notice != null) {
            stmt.bindString(15, notice);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public CompanionDB readEntity(Cursor cursor, int offset) {
        CompanionDB entity = new CompanionDB( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // push_id
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // service_id
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // type
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // release_time
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // content_lists
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // isDownload
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // uid
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // key
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // message
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // image
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // reply
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // is_upload_finish
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // receiver_time
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14) // notice
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, CompanionDB entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setPush_id(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setService_id(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setType(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setRelease_time(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setContent_lists(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setIsDownload(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setUid(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setKey(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setMessage(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setImage(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setReply(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setIs_upload_finish(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setReceiver_time(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setNotice(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
     }
    
    @Override
    protected final String updateKeyAfterInsert(CompanionDB entity, long rowId) {
        return entity.getId();
    }
    
    @Override
    public String getKey(CompanionDB entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(CompanionDB entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
