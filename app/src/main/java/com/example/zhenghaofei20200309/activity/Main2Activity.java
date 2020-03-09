package com.example.zhenghaofei20200309.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhenghaofei20200309.R;
import com.example.zhenghaofei20200309.base.BaseActivity;
import com.example.zhenghaofei20200309.base.BasePresenter;
import com.example.zhenghaofei20200309.contert.IContert;
import com.example.zhenghaofei20200309.presenter.Presenter;
import com.example.zhenghaofei20200309.util.VolleyUtil;

import java.util.HashMap;

/**
 * Zhenghaofei20200309
 * 注册
 * 2020-03-09
 */
public class Main2Activity extends BaseActivity implements IContert.IView, View.OnClickListener {


    private EditText name;
    private EditText psw;
    private TextView yi;
    private Button zhuce;

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main2;
    }

    @Override
    protected void initView() {
        //获取控件
        name = findViewById(R.id.name);
        psw = findViewById(R.id.psw);
        yi = findViewById(R.id.yi);
        zhuce = findViewById(R.id.zhuce);
    }

    @Override
    protected void initData() {
        //点击事件
        zhuce.setOnClickListener(this);
        yi.setOnClickListener(this);
    }

    @Override
    public void getMessage(String str) {
        Log.i("xxx",""+str);
    }

    @Override
    public void getErroy(String str) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.zhuce:
                Boolean wifi = VolleyUtil.getInstance().isWifi(this);
                if (wifi){
                    //判断
                    if (!TextUtils.isEmpty(name.getText().toString())&&!TextUtils.isEmpty(psw.getText().toString())){
                        String url="http://mobile.bwstudent.com/small/user/v1/register";
                        HashMap<String, String> map = new HashMap<>();
                        map.put("phone",name.getText().toString());
                        map.put("pwd",psw.getText().toString());
                        BasePresenter presenter = getPresenter();
                        if (presenter!=null && presenter instanceof IContert.IPresenter){
                            //注册
                            ((IContert.IPresenter)presenter).getJson(url,map);
                        }
                    }else {
                        Toast.makeText(this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(this, "没有网络", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.yi:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
