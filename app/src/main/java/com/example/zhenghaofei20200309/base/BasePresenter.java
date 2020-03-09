package com.example.zhenghaofei20200309.base;

import java.lang.ref.WeakReference;
/**
 * Zhenghaofei20200309
 * BasePresenter
 * 2020-03-09
 */
public abstract class BasePresenter<V extends IBaseView> {

    private WeakReference<V> vWeakReference;

    public BasePresenter(V v) {
        vWeakReference = new WeakReference<>(v);
        initModel();
    }
    public V getView(){
        if (vWeakReference!=null){
            return vWeakReference.get();
        }
            return null;
    }

    protected abstract void initModel();
    public void Destory(){
        if (vWeakReference!=null){
            vWeakReference.clear();
            vWeakReference=null;
        }
    }
}
