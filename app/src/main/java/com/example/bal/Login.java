package com.example.bal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    SharedPrefManager sp;
    EditText nama, email;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nama = findViewById(R.id.edt_nama);
        email = findViewById(R.id.edt_email);
        btnlogin = findViewById(R.id.btn_Login);

        sp = new SharedPrefManager(this);
        //sp = new SharedPrefManager(this);

        ceklogin();

        login();
    }


    public void login() {
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nam = nama.getText().toString();
                String e = email.getText().toString();

                sp.saveSPString(SharedPrefManager.SP_NAMA, nam);
                sp.saveSPString(SharedPrefManager.SP_EMAIL, e);

                sp.saveSPBolean(SharedPrefManager.SP_SUDAH_LOGIN, true);

                startActivity(new Intent(Login.this, MainActivity.class));

                Toast.makeText(getApplicationContext(), "Success Login", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void ceklogin() {

        if (sp.Login()){
            startActivity(new Intent(Login.this, MainActivity.class));
            finish();
        }
    }

}
