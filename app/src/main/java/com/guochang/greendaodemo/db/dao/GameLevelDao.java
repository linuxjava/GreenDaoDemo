package com.guochang.greendaodemo.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.guochang.greendaodemo.db.entity.GameLevel;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table game_level.
*/
public class GameLevelDao extends AbstractDao<GameLevel, Long> {

    public static final String TABLENAME = "game_level";

    /**
     * Properties of entity GameLevel.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property GameType = new Property(1, int.class, "gameType", false, "GAME_TYPE");
        public final static Property Level = new Property(2, int.class, "level", false, "LEVEL");
        public final static Property SumCount = new Property(3, Integer.class, "sumCount", false, "SUM_COUNT");
        public final static Property RightCount = new Property(4, Integer.class, "rightCount", false, "RIGHT_COUNT");
        public final static Property Reserve = new Property(5, String.class, "reserve", false, "RESERVE");
    };


    public GameLevelDao(DaoConfig config) {
        super(config);
    }
    
    public GameLevelDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'game_level' (" + //
                "'_id' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "'GAME_TYPE' INTEGER NOT NULL ," + // 1: gameType
                "'LEVEL' INTEGER NOT NULL ," + // 2: level
                "'SUM_COUNT' INTEGER," + // 3: sumCount
                "'RIGHT_COUNT' INTEGER," + // 4: rightCount
                "'RESERVE' TEXT);"); // 5: reserve
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'game_level'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, GameLevel entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getGameType());
        stmt.bindLong(3, entity.getLevel());
 
        Integer sumCount = entity.getSumCount();
        if (sumCount != null) {
            stmt.bindLong(4, sumCount);
        }
 
        Integer rightCount = entity.getRightCount();
        if (rightCount != null) {
            stmt.bindLong(5, rightCount);
        }
 
        String reserve = entity.getReserve();
        if (reserve != null) {
            stmt.bindString(6, reserve);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public GameLevel readEntity(Cursor cursor, int offset) {
        GameLevel entity = new GameLevel( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getInt(offset + 1), // gameType
            cursor.getInt(offset + 2), // level
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // sumCount
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4), // rightCount
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // reserve
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, GameLevel entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setGameType(cursor.getInt(offset + 1));
        entity.setLevel(cursor.getInt(offset + 2));
        entity.setSumCount(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setRightCount(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
        entity.setReserve(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(GameLevel entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(GameLevel entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
