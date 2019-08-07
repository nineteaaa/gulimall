package com.atguigu.gulimall.commons.utils;

public class AppUtils {
    public static String arrayToStringWithSeparator(String[] arr, String sep) {

        StringBuffer sb = new StringBuffer();
        if (arr != null && arr.length > 0) {
            for (String s : arr) {
                sb.append(s);
                sb.append(sep);
            }
            String sub = sb.toString().substring(0, sb.length()-1);
            return sub;
        }
        return null;


    }
}