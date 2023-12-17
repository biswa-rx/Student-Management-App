package com.example.studentmanagement.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.studentmanagement.R;
import com.example.studentmanagement.data.remote.RetrofitHelper;
import com.example.studentmanagement.data.repository.StudentRepository;
import com.example.studentmanagement.presentation.admin.AdminLogin;
import com.example.studentmanagement.presentation.student.StudentLogin;
import com.example.studentmanagement.presentation.teacher.TeacherLogin;

public class RootLoginScreen extends AppCompatActivity {

    Button studentLoginButton,teacherLoginButton,adminLoginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root_login_screen);
        studentLoginButton = findViewById(R.id.student_login_bt);
        teacherLoginButton = findViewById(R.id.teacher_login_bt);
        adminLoginButton = findViewById(R.id.admin_login_bt);

        studentLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RootLoginScreen.this,StudentLogin.class);
                startActivity(intent);
            }
        });
        teacherLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RootLoginScreen.this, TeacherLogin.class));
            }
        });
        adminLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RootLoginScreen.this, AdminLogin.class));
            }
        });
    }
}