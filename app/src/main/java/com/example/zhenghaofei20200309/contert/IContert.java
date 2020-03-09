package com.example.zhenghaofei20200309.contert;

import com.example.zhenghaofei20200309.base.IBaseView;

import java.util.Map;
/**
 * Zhenghaofei20200309
 * 契约类
 * 2020-03-09
 */
public interface IContert {
    interface IView extends IBaseView{
        void getMessage(String str);
        void getErroy(String str);
    }
    interface IPresenter{
        void getJson(String url, Map<String,String> map);
    }
    interface IModel{
        void getJson(String url,Map<String,String> map,Callback callback);
    }
    interface Callback{
        void getMessage(String str);
        void getErroy(String str);
    }
}
