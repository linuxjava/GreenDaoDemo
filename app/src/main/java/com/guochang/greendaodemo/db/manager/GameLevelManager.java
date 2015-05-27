package com.guochang.greendaodemo.db.manager;

import android.content.Context;

import com.guochang.greendaodemo.db.dao.GameLevelDao;
import com.guochang.greendaodemo.db.entity.GameLevel;

import java.util.List;

/**
 * Created by guochang on 2015/4/16.
 */
public class GameLevelManager {
    private static GameLevelManager mInstance;
    private GameLevelDao mDao;

    private GameLevelManager(){

    }

    private GameLevelManager(Context c){
        mDao = BaseManager.getInstance(c).getDaoSession().getGameLevelDao();
    }

    public synchronized static GameLevelManager getInstance(Context c){
        if(mInstance == null){
            mInstance = new GameLevelManager(c);
        }

        return mInstance;
    }


    public synchronized void insert(GameLevel entity){
        mDao.insert(entity);
    }

    public synchronized List<GameLevel> getAll(){
        return mDao.loadAll();
    }
}
