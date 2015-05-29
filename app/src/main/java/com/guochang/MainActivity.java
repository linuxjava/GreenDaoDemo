package com.guochang;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.guochang.greendaodemo.R;
import com.guochang.greendaodemo.db.entity.GameLevel;
import com.guochang.greendaodemo.db.manager.AppPropertyManager;
import com.guochang.greendaodemo.db.manager.GameLevelManager;

import java.util.List;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test3();
    }

    private void test1() {
        GameLevelManager manager = GameLevelManager.getInstance(this);
//        manager.insert(new GameLevel(0, 0, 0, 0));
//        manager.insert(new GameLevel(1, 1, 1, 1));

        List<GameLevel> list = manager.getAll();
    }

    private void test2() {
        AppPropertyManager.getInstance(this).putBoolean(AppPropertyManager.KEY_BOOLEAN_TEST1, true);
        AppPropertyManager.getInstance(this).putString(AppPropertyManager.KEY_STRING_TEST2, "asdfasdf");
        AppPropertyManager.getInstance(this).putInt(AppPropertyManager.KEY_INT_TEST3, 10);
        AppPropertyManager.getInstance(this).putLong(AppPropertyManager.KEY_LONG_TEST4, 11234567890L);
    }

    private void test3() {
        boolean test1 = AppPropertyManager.getInstance(this).getBoolean(AppPropertyManager.KEY_BOOLEAN_TEST1, false);
        String test2 = AppPropertyManager.getInstance(this).getString(AppPropertyManager.KEY_STRING_TEST2, "test");
        int test3 = AppPropertyManager.getInstance(this).getInt(AppPropertyManager.KEY_INT_TEST3, -1);
        long test4 = AppPropertyManager.getInstance(this).getLong(AppPropertyManager.KEY_LONG_TEST4, 0L);

        Log.d("xiao1", test1 + ":" + test2 + ":" + test3 + ":" + test4);
    }
}
