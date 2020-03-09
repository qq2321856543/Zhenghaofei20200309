package com.example.zhenghaofei20200309.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.zhenghaofei20200309.base.App;
import com.example.zhenghaofei20200309.model.Model;

import java.util.Map;
/**
 * Zhenghaofei20200309
 * 工具类
 * 2020-03-09
 */
public class VolleyUtil {
      RequestQueue queue;



    private VolleyUtil() {
        queue = Volley.newRequestQueue(App.getContext());
    }
    private static class getUtil{
        private static final VolleyUtil volleyUtil=new VolleyUtil();
    }
    public static VolleyUtil getInstance(){
        return getUtil.volleyUtil;
    }
    public Boolean isWifi(Context context){
        ConnectivityManager cm= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info!=null){
            return true;
        }
        return false;
    }
    public void doGet(String url, final Callback callback){
        StringRequest stringRequest = new StringRequest(StringRequest.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.getMessage(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.getErroy(error.getMessage());
            }
        }
        );
        queue.add(stringRequest);
    }
    public void doPost(String url, final Map<String,String> map, final Callback callback){
        StringRequest stringRequest = new StringRequest(StringRequest.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.getMessage(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.getErroy(error.getMessage());
            }
        }
        ){
            @Override
            protected Map<String, String> getParams() {
                return map;
            }
        };
        queue.add(stringRequest);
    }
    public interface Callback{
        void getMessage(String str);
        void getErroy(String str);
    }
}
