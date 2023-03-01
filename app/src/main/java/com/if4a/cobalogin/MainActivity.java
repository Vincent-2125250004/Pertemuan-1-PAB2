package com.if4a.cobalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    KendaliLogin KL = new KendaliLogin();
    private TextView tvSesi, tvname;
    private String ambilSesi;
    private MaterialButton BtnLogout;
    public static String keySPusername ="spPadang";
    public static String keySPname ="spPadangname";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (KL.isLogin(MainActivity.this,keySPusername)== true){
            setContentView(R.layout.activity_main);
            tvSesi = findViewById(R.id.tv_sesi);
            tvname = findViewById(R.id.tv_name);
            BtnLogout = findViewById(R.id.btn_logout);

            tvSesi.setText(KL.getPref(MainActivity.this,keySPusername));
            tvname.setText(KL.getPref(MainActivity.this,keySPname));

            BtnLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    KL.setPref(MainActivity.this, keySPusername, null);
                    KL.setPref(MainActivity.this, keySPname, null);
                    startActivity(new Intent(MainActivity.this, activity_login.class));
                    finish();
                }
            });
        }
        else {
            startActivity(new Intent(MainActivity.this, activity_login.class));
            finish();
        }

    }
}