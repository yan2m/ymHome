package com.example.ymhome.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Jyan on 2015/11/30.
 * Mail:jyan.lin@foxmail.com
 */
public class Util {

    public static final String PREF_NAME = "config";

    /**
     * SP util
     */
    public static boolean getBoolean(Context ctx,String key,boolean defaultValue){
        SharedPreferences sp = ctx.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        return sp.getBoolean(key,defaultValue) ;
    }

    public static void setBoolean(Context ctx,String key,boolean value){
        SharedPreferences sp = ctx.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        sp.edit().putBoolean(key,value).commit();
    }
    /**
     * dp转px
     */
    public static int dp2px(Context ctx,float dp){
        float density = ctx.getResources().getDisplayMetrics().density;
        return (int) (dp*density +0.5f);
    }
    /**
     * px转dp
     */
    public static float px2dp(Context ctx,int px){
        float density = ctx.getResources().getDisplayMetrics().density;
        return px/density;
    }

}
