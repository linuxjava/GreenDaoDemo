package com.guochang.util;

import android.util.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by guochang on 2015/5/29.
 */
public class Stringutil {
    // 通过路径生成Base64文件
    public static String getBase64FromPath(String path)
    {
        String base64="";
        try
        {
            File file = new File(path);
            byte[] buffer = new byte[(int) file.length() + 100];
            @SuppressWarnings("resource")
            int length = new FileInputStream(file).read(buffer);
            base64 = Base64.encodeToString(buffer, 0, length, Base64.DEFAULT);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return base64;
    }
}
