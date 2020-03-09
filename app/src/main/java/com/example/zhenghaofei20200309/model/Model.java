package com.example.zhenghaofei20200309.model;

import com.example.zhenghaofei20200309.contert.IContert;
import com.example.zhenghaofei20200309.util.VolleyUtil;

import java.util.Map;
/**
 * Zhenghaofei20200309
 * M层
 * 2020-03-09
 */
public class Model implements IContert.IModel {
    @Override
    public void getJson(String url, Map<String, String> map, final IContert.Callback callback) {
        VolleyUtil.getInstance().doPost(url, map, new VolleyUtil.Callback() {
            @Override
            public void getMessage(String str) {
                callback.getMessage(str);
            }

            @Override
            public void getErroy(String str) {
                callback.getErroy(str);
            }
        });
    }
}
