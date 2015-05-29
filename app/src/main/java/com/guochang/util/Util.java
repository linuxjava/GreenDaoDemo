package com.guochang.util;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by guochang on 2015/1/11.
 */
public class Util {
    // 修改整个界面所有控件的字体
    public static void changeFonts(ViewGroup root,String path, Activity act) {
        //path是字体路径
        Typeface tf = Typeface.createFromAsset(act.getAssets(),path);
        for (int i = 0; i < root.getChildCount(); i++) {
            View v = root.getChildAt(i);
            if (v instanceof TextView) {
                ((TextView) v).setTypeface(tf);
            } else if (v instanceof Button) {
                ((Button) v).setTypeface(tf);
            } else if (v instanceof EditText) {
                ((EditText) v).setTypeface(tf);
            } else if (v instanceof ViewGroup) {
                changeFonts((ViewGroup) v, path,act);
            }
        }
    }

    // 修改整个界面所有控件的字体大小
    public static void changeTextSize(ViewGroup root,int size, Activity act) {
        for (int i = 0; i < root.getChildCount(); i++) {
            View v = root.getChildAt(i);
            if (v instanceof TextView) {
                ((TextView) v).setTextSize(size);
            } else if (v instanceof Button) {
                ((Button) v).setTextSize(size);
            } else if (v instanceof EditText) {
                ((EditText) v).setTextSize(size);
            } else if (v instanceof ViewGroup) {
                changeTextSize((ViewGroup) v,size,act);
            }
        }
    }
}
