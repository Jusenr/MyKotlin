package com.myself.mykotlin.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.myself.mykotlin.db.entity.PaibandDB;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "putao_wd_store_paiband".
*/
public class PaibandDBDao extends AbstractDao<PaibandDB, Long> {

    public static final String TABLENAME = "putao_wd_store_paiband";

    /**
     * Properties of entity PaibandDB.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property _id = new Property(0, Long.class, "_id", true, "_ID");
        public final static Property Cid = new Property(1, String.class, "cid", false, "CID");
        public final static Property Data_content = new Property(2, String.class, "data_content", false, "DATA_CONTENT");
        public final static Property Date = new Property(3, String.class, "date", false, "DATE");
        public final static Property Is_uploaded = new Property(4, String.class, "is_uploaded", false, "IS_UPLOADED");
    }


    public PaibandDBDao(DaoConfig config) {
        super(config);
    }
    
    public PaibandDBDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"putao_wd_store_paiband\" (" + //
                "\"_ID\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: _id
                "\"CID\" TEXT," + // 1: cid
                "\"DATA_CONTENT\" TEXT," + // 2: data_content
                "\"DATE\" TEXT," + // 3: date
                "\"IS_UPLOADED\" TEXT);"); // 4: is_uploaded
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"putao_wd_store_paiband\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, PaibandDB entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
 
        String cid = entity.getCid();
        if (cid != null) {
            stmt.bindString(2, cid);
        }
 
        String data_content = entity.getData_content();
        if (data_content != null) {
            stmt.bindString(3, data_content);
        }
 
        String date = entity.getDate();
        if (date != null) {
            stmt.bindString(4, date);
        }
 
        String is_uploaded = entity.getIs_uploaded();
        if (is_uploaded != null) {
            stmt.bindString(5, is_uploaded);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, PaibandDB entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
 
        String cid = entity.getCid();
        if (cid != null) {
            stmt.bindString(2, cid);
        }
 
        String data_content = entity.getData_content();
        if (data_content != null) {
            stmt.bindString(3, data_content);
        }
 
        String date = entity.getDate();
        if (date != null) {
            stmt.bindString(4, date);
        }
 
        String is_uploaded = entity.getIs_uploaded();
        if (is_uploaded != null) {
            stmt.bindString(5, is_uploaded);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public PaibandDB readEntity(Cursor cursor, int offset) {
        PaibandDB entity = new PaibandDB( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // _id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // cid
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // data_content
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // date
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // is_uploaded
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, PaibandDB entity, int offset) {
        entity.set_id(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCid(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setData_content(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDate(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setIs_uploaded(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(PaibandDB entity, long rowId) {
        entity.set_id(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(PaibandDB entity) {
        if(entity != null) {
            return entity.get_id();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(PaibandDB entity) {
        return entity.get_id() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}