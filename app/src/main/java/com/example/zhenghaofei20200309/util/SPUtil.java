package com.example.zhenghaofei20200309.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SPUtil {
    public static void putString(Context context,String name,String key,String values){
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(key,values);
        edit.commit();
    }
    public static String getString(Context context,String name,String key){
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sp.getString(key,"");
    }

    public static void putInt(Context context,String name,String key,int values){
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt(key,values);
        edit.commit();
    }
    public static int getInt(Context context,String name,String key){
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sp.getInt(key,0);
    }

    public static void putBoolean(Context context,String name,String key,Boolean values){
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean(key,values);
        edit.commit();
    }
    public static Boolean getBoolean(Context context,String name,String key){
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sp.getBoolean(key,false);
    }
}
