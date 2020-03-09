package com.example.zhenghaofei20200309.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.zhenghaofei20200309.R;
import com.example.zhenghaofei20200309.base.BaseActivity;
import com.example.zhenghaofei20200309.base.BasePresenter;
import com.example.zhenghaofei20200309.util.SPUtil;
/**
 * Zhenghaofei20200309
 * 折线图
 * 2020-03-09
 */
public class Main3Activity extends BaseActivity {

    private ImageView iv;
    private TextView tv;
    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main3;
    }

    @Override
    protected void initView() {
         iv = findViewById(R.id.iv);
         tv = findViewById(R.id.tv);
        String headPic = SPUtil.getString(this, "bb", "headPic");
        String nickName = SPUtil.getString(this, "bb", "nickName");
        Glide.with(this).load(headPic).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                .apply(RequestOptions.bitmapTransform(new CircleCrop())).into(iv);
        tv.setText(nickName);
    }

    @Override
    protected void initData() {

    }
}
