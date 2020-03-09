package com.example.zhenghaofei20200309.base;

import android.app.Application;
import android.content.Context;
/**
 * Zhenghaofei20200309
 * app
 * 2020-03-09
 */
public class App extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
    public static Context getContext(){
        return context;
    }
}
