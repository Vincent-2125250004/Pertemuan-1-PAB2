package com.if4a.cobalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class activity_login extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private MaterialButton BtnLogin;
    private String username, password;

    KendaliLogin KL = new KendaliLogin();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        BtnLogin = findViewById(R.id.btn_login);

        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = etUsername.getText().toString();
                password = etPassword.getText().toString();


                if (username.trim().isEmpty()){
                    etUsername.setError("Username Tidak Boleh Kosong");
                }
                else if (password.trim().isEmpty()) {
                    etPassword.setError("Password Tidak Boleh Kosong");
                }
                else {
                    if (username.equals("Cent")&& password.equals("hehe")){
                        KL.setPref(activity_login.this,MainActivity.keySPusername, username);
                        KL.setPref(activity_login.this, MainActivity.keySPname, "Vincent");
                        startActivity(new Intent(activity_login.this, MainActivity.class));
                        finish();
                    }
                    else if (username.equals("Apek")&& password.equals("hehehe")){
                        KL.setPref(activity_login.this,MainActivity.keySPusername, username);
                        KL.setPref(activity_login.this, MainActivity.keySPname, "PekCun");
                        startActivity(new Intent(activity_login.this, MainActivity.class));
                        finish();
                    }
                    else {
                        Toast.makeText(activity_login.this, "Username atau Password salah", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}