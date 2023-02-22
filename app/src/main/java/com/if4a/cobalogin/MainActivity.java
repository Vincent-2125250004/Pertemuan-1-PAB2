package com.if4a.cobalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    KendaliLogin KL = new KendaliLogin();
    private TextView tvSesi;
    private String ambilSesi;
    private MaterialButton BtnLogout;
    public static String keySPusername ="spPadang";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (KL.isLogin(MainActivity.this,keySPusername)== true){
            setContentView(R.layout.activity_main);
            tvSesi = findViewById(R.id.tv_sesi);
            BtnLogout = findViewById(R.id.btn_logout);
        }
        else {
            startActivity(new Intent(MainActivity.this, activity_login.class));
            finish();
        }

    }
}