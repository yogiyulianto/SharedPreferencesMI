package com.example.bal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPrefManager sp;
    TextView nama, email;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = findViewById(R.id.txtnama);
        email = findViewById(R.id.txtemail);
        btnlogin = findViewById(R.id.btn_Login);

        sp = new SharedPrefManager(this);

        nama.setText("" + sp.getKeyNama());

        logout();

    }

    private void logout() {
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.saveSPBolean(SharedPrefManager.SP_SUDAH_LOGIN, false);

                startActivity(new Intent(MainActivity.this,Login.class));

                Toast.makeText(getApplicationContext(), "Success Login", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
