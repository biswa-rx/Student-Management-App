package com.example.studentmanagement.presentation.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.studentmanagement.R;

public class StudentDashBoard extends AppCompatActivity {

    String studentName;
    int studentRollno;
    TextView studentNameDashTv,studentRollnoDashTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dash_board);
        studentNameDashTv = findViewById(R.id.dash_name_tv);
        studentRollnoDashTv = findViewById(R.id.student_roll_dash_tv);
        Intent intent = getIntent();
        if (intent != null) {
            studentName = intent.getStringExtra("std_name");
            studentRollno = intent.getIntExtra("std_roll",100);
        }

        if(studentName != null){
            studentNameDashTv.setText(studentName);
            studentRollnoDashTv.setText("Your Roll Number - "+ studentRollno);
        }
    }
}