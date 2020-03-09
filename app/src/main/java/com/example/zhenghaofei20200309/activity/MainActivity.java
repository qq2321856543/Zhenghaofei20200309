package com.example.zhenghaofei20200309.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhenghaofei20200309.R;
import com.example.zhenghaofei20200309.base.BaseActivity;
import com.example.zhenghaofei20200309.base.BasePresenter;
import com.example.zhenghaofei20200309.bean.LogBean;
import com.example.zhenghaofei20200309.bean.LoginBean;
import com.example.zhenghaofei20200309.contert.IContert;
import com.example.zhenghaofei20200309.presenter.Presenter;
import com.example.zhenghaofei20200309.util.SPUtil;
import com.example.zhenghaofei20200309.util.VolleyUtil;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
/**
 * Zhenghaofei20200309
 * 登录
 * 2020-03-09
 */
public class MainActivity extends BaseActivity implements IContert.IView, View.OnClickListener {


    private EditText name;
    private EditText psw;
    private CheckBox cb;
    private Button zhuce;
    private Button denglu;

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }


    @Override
    protected void initView() {
        //获取控件
        name = findViewById(R.id.name);
        psw = findViewById(R.id.psw);
        cb = findViewById(R.id.cb);
        zhuce = findViewById(R.id.zhuce);
        denglu = findViewById(R.id.denglu);

    }

    @Override
    protected void initData() {
        //设置值
        name.setText(SPUtil.getString(this, "bb", "name"));
        Boolean aBoolean = SPUtil.getBoolean(this, "bb", "cb");
        cb.setChecked(aBoolean);
        if (aBoolean){
            psw.setText(SPUtil.getString(this,"bb","psw"));
        }
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SPUtil.putBoolean(getApplicationContext(),"bb","cb",isChecked);
            }
        });
        //点击事件
        zhuce.setOnClickListener(this);
        denglu.setOnClickListener(this);
    }

    @Override
    public void getMessage(String str) {
        Log.i("xxx",""+str);
        Gson gson = new Gson();
        LoginBean loginBean = gson.fromJson(str, LoginBean.class);
        String message = loginBean.getMessage();

        LogBean logBean = gson.fromJson(str, LogBean.class);
        LogBean.ResultBean result = logBean.getResult();
        String headPic = result.getHeadPic();
        String nickName = result.getNickName();


        //登陆成功
        if (message.equals("登录成功")){
            SPUtil.putString(this,"bb","name",name.getText().toString());
            SPUtil.putString(this,"bb","psw",psw.getText().toString());

            SPUtil.putString(this,"bb","headPic",headPic);
            SPUtil.putString(this,"bb","nickName",nickName);

            Intent intent = new Intent(this, Main3Activity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void getErroy(String str) {

    }

    @Override
    public void onClick(View v) {
        //判断id
        switch (v.getId()){
            case R.id.zhuce:
                Intent intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.denglu:
                    init();
                break;

        }
    }
    public void init(){
        Boolean wifi = VolleyUtil.getInstance().isWifi(this);
        if (wifi){
            if (!TextUtils.isEmpty(name.getText().toString()) && !TextUtils.isEmpty(psw.getText().toString())){
                String url="http://mobile.bwstudent.com/small/user/v1/login";
                HashMap<String, String> map = new HashMap<>();
                map.put("phone",name.getText().toString());
                map.put("pwd",psw.getText().toString());
                BasePresenter presenter = getPresenter();
                if (presenter!=null && presenter instanceof IContert.IPresenter){
                    ((IContert.IPresenter)presenter).getJson(url,map);
                }
            }else {
                Toast.makeText(this, "账号密码不能为空", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this, "没有网络", Toast.LENGTH_SHORT).show();
        }
    }
}
