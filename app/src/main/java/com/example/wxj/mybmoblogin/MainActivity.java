package com.example.wxj.mybmoblogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etusename,etpassword;
    private Button btnlogin,btncancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relativeout);
        Bmob.initialize(this, "f30810b4822dd7f2bb18754dd654f456");
        init();
    }

    private void init() {
        etusename=(EditText)findViewById(R.id.et_use_name);
        etpassword=(EditText)findViewById(R.id.et_password);
        btnlogin=(Button)findViewById(R.id.btn1);
        btnlogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                login();
                break;
        }
    }
    private void login(){
        String strUserName=etusename.getText().toString();
        String strPassword=etpassword.getText().toString();


        BmobUser bu2 = new BmobUser();
        bu2.setUsername(strUserName);
        bu2.setPassword(strPassword);
        bu2.login(new SaveListener<BmobUser>() {

            @Override
            public void done(BmobUser bmobUser, BmobException e) {
                if(e==null){
                    Toast.makeText(MainActivity.this,"登录成功！",Toast.LENGTH_SHORT).show();
                    //通过BmobUser user = BmobUser.getCurrentUser()获取登录成功后的本地用户信息
                    //如果是自定义用户对象MyUser，可通过MyUser user = BmobUser.getCurrentUser(MyUser.class)获取自定义用户信息
                }else{
                    Toast.makeText(MainActivity.this,"登录失败："+e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
