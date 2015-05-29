package com.guochang.util;

import java.util.Random;

/**
 * Created by guochang on 2015/5/29.
 */
public class RandomUtil {
    /**
     * ���ָ����Χ��N�����ظ�����
     * �ڳ�ʼ�������ظ���ѡ�������������һ�����������У�
     * ����ѡ���鱻������������ô�ѡ����(len-1)�±��Ӧ�����滻
     * Ȼ���len-2�����������һ����������������
     * @param max  ָ����Χ���ֵ
     * @param min  ָ����Χ��Сֵ
     * @param n  ���������
     * @return int[] ����������
     */
    public static int[] randomArray(int min,int max,int n){
        int len = max-min+1;

        if(max < min || n > len){
            return null;
        }

        //��ʼ��������Χ�Ĵ�ѡ����
        int[] source = new int[len];
        for (int i = min; i < min+len; i++){
            source[i-min] = i;
        }

        int[] result = new int[n];
        Random rd = new Random();
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            //��ѡ����0��(len-2)���һ���±�
            index = Math.abs(rd.nextInt() % len--);
            //�������������������
            result[i] = source[index];
            //����ѡ�����б�������������ô�ѡ����(len-1)�±��Ӧ�����滻
            source[index] = source[len];
        }
        return result;
    }

    public static int random(int min, int max) {
        if (min < max) {
            return -1;
        }

        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }

    public static String get15Random() {
        String str = "";
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            str += random.nextInt(10);
        }
        return str;
    }
}
