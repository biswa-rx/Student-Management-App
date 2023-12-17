package com.example.studentmanagement.presentation.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.studentmanagement.R;

public class AdminLogin extends AppCompatActivity {

    EditText edAdminId,edAdminPassword;
    Button loginButtonAdmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        loginButtonAdmin = findViewById(R.id.bt_admin_login);
        edAdminId = findViewById(R.id.ed_id_admin);
        edAdminPassword = findViewById(R.id.ed_password_admin);

        loginButtonAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edAdminId.getText().toString().equals("admin") && edAdminPassword.getText().toString().equals("password")) {
                    Intent intent = new Intent(AdminLogin.this,AdminActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(AdminLogin.this,"User Id and Password is wrong",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}