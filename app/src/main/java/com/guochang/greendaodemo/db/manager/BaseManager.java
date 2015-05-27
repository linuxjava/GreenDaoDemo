package com.guochang.greendaodemo.db.manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.guochang.greendaodemo.db.dao.DaoMaster;
import com.guochang.greendaodemo.db.dao.DaoSession;

/**
 * Created by guochang on 2015/4/15.
 */
public class BaseManager {
    private static final String DBNAME = "speechGame";
    private static BaseManager mInstance;
    private DaoSession mDaoSession;

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    private BaseManager(){

    }

    private BaseManager(Context c){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(c, DBNAME, null);
        SQLiteDatabase db = helper.getWritableDatabase();
        mDaoSession = new DaoMaster(db).newSession();
    }

    public static synchronized BaseManager getInstance(Context c){
        if(mInstance == null){
            mInstance = new BaseManager(c);
        }

        return mInstance;
    }
}
