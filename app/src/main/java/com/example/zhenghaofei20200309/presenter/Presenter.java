package com.example.zhenghaofei20200309.presenter;

import com.example.zhenghaofei20200309.base.BasePresenter;
import com.example.zhenghaofei20200309.base.IBaseView;
import com.example.zhenghaofei20200309.contert.IContert;
import com.example.zhenghaofei20200309.model.Model;

import java.util.Map;
/**
 * Zhenghaofei20200309
 * P层
 * 2020-03-09
 */
public class Presenter extends BasePresenter implements IContert.IPresenter {

    private Model model;

    public Presenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        model = new Model();
    }

    @Override
    public void getJson(String url, Map<String, String> map) {
        model.getJson(url, map, new IContert.Callback() {
            @Override
            public void getMessage(String str) {
                IBaseView view = getView();
                if (view!=null && view instanceof IContert.IView){
                    ((IContert.IView)view).getMessage(str);
                }
            }

            @Override
            public void getErroy(String str) {
                IBaseView view = getView();
                if (view!=null && view instanceof IContert.IView){
                    ((IContert.IView)view).getErroy(str);
                }
            }
        });
    }
}
