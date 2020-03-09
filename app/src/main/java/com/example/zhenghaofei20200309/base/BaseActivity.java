package com.example.zhenghaofei20200309.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.zhenghaofei20200309.R;
/**
 * Zhenghaofei20200309
 * BaseActivity
 * 2020-03-09
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    private P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
        presenter = initPresenter();
        initData();
    }
    public P getPresenter(){
        return presenter;
    }

    protected abstract P initPresenter();

    protected abstract int getLayout();

    protected abstract void initView();

    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.Destory();
            presenter=null;
        }
    }
}
