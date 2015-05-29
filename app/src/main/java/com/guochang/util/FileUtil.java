package com.guochang.util;

/**
 * Created by guochang on 2015/4/16.
 */
public class FileUtil {
    // 从路径获取文件名
    public static String getFileName(String pathandname){
        int start=pathandname.lastIndexOf("/");
        int end=pathandname.lastIndexOf(".");
        if(start!=-1 && end!=-1){
            return pathandname.substring(start+1,end);
        }else{
            return null;
        }
    }
}
