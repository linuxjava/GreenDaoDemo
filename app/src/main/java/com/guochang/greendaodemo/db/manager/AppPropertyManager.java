package com.guochang.greendaodemo.db.manager;

import android.content.Context;
import android.text.TextUtils;

import com.guochang.greendaodemo.db.dao.AppPropertyDao;
import com.guochang.greendaodemo.db.entity.AppProperty;

import java.util.List;

import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.WhereCondition;

/**
 * Created by guochang on 2015/4/16.
 */
public class AppPropertyManager {
    public static final String KEY_BOOLEAN_TEST1 = "test1";
    public static final String KEY_STRING_TEST2 = "test2";
    public static final String KEY_INT_TEST3 = "test3";
    public static final String KEY_LONG_TEST4 = "test4";
    private static AppPropertyManager mInstance;
    private AppPropertyDao mDao;

    private AppPropertyManager(){

    }

    private AppPropertyManager(Context c){
        mDao = BaseManager.getInstance(c).getDaoSession().getAppPropertyDao();
    }

    public synchronized static AppPropertyManager getInstance(Context c){
        if(mInstance == null){
            mInstance = new AppPropertyManager(c);
        }

        return mInstance;
    }

    public synchronized void putInt(String key, int value){
        if(TextUtils.isEmpty(key)){
            return;
        }

        AppProperty property = new AppProperty(key, value+"");
        mDao.insert(property);
    }

    public synchronized void putLong(String key, Long value){
        if(TextUtils.isEmpty(key)){
            return;
        }

        AppProperty property = new AppProperty(key, value+"");
        mDao.insert(property);
    }

    public synchronized void putString(String key, String value){
        if(TextUtils.isEmpty(key)){
            return;
        }

        AppProperty property = new AppProperty(key, value);
        mDao.insert(property);
    }

    public synchronized void putBoolean(String key, boolean value){
        if(TextUtils.isEmpty(key)){
            return;
        }

        AppProperty property = new AppProperty(key, value ? "true" : "false");
        mDao.insert(property);
    }

    public synchronized int getInt(String key, int def){
        String value = query(key);
        if(!TextUtils.isEmpty(value)){
            return Integer.valueOf(value);
        }

        return def;
    }

    public synchronized long getLong(String key, long def){
        String value = query(key);
        if(!TextUtils.isEmpty(value)){
            return Long.valueOf(value);
        }

        return def;
    }

    public synchronized String getString(String key, String def){
        String value = query(key);
        if(!TextUtils.isEmpty(value)){
            return value;
        }

        return def;
    }

    public synchronized boolean getBoolean(String key, boolean def){
        String value = query(key);
        if(!TextUtils.isEmpty(value)){
            return "true".equalsIgnoreCase(value)? true : false;
        }

        return def;
    }

    private String query(String key){
        if(TextUtils.isEmpty(key)){
            return null;
        }

        WhereCondition condition = AppPropertyDao.Properties.PropertyKey.eq(key);
        Query<AppProperty> query = mDao.queryBuilder().where(condition).build();

        List<AppProperty> list = query.list();
        if(list != null && list.size() == 1){
            return list.get(0).getPropertyValue();
        }

        return null;
    }
}
