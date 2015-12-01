package com.example.ymhome.utils;

import android.content.Context;

/**
 * Created by Jyan on 2015/11/30.
 * Mail:jyan.lin@foxmail.com
 */
public class Util {
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
