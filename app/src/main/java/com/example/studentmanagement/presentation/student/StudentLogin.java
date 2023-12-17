package com.example.studentmanagement.presentation.student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.studentmanagement.R;
import com.example.studentmanagement.domain.model.Student;
import com.example.studentmanagement.presentation.StudentManagementApplication;

import java.util.List;
import java.util.Objects;

public class StudentLogin extends AppCompatActivity {

    StudentViewModel studentViewModel;
    EditText student_rollno,student_password;
    Button student_login;
    List<Student> studentList;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        student_login = findViewById(R.id.bt_student_login);
        student_rollno = findViewById(R.id.ed_id_student);
        student_password = findViewById(R.id.ed_password_student);
        sharedPreferences = getSharedPreferences("StudentPassword", Context.MODE_PRIVATE);
        studentViewModel = new ViewModelProvider(this,new StudentViewModelFactory(StudentManagementApplication.studentRepository)).get(StudentViewModel.class);

        autoLogin(); //Try to auto login by shared preferences

        student_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(studentList != null && studentList.size()>0){
                   for(Student it: studentList){
                       if(it.getRoll_no() == Integer.parseInt(student_rollno.getText().toString())){
                           if(Objects.equals(it.getPassword(), student_password.getText().toString())){
                               Student currentStudent = it;
                               //For future fast login save password
                               SharedPreferences.Editor editor = sharedPreferences.edit();
                               editor.putInt("student_roll", currentStudent.getRoll_no());
                               editor.putString("student_password", currentStudent.getPassword());
                               editor.putString("student_name", currentStudent.getName());
                               editor.apply();

                               Toast.makeText(StudentLogin.this,"Hello "+currentStudent.getName(),Toast.LENGTH_LONG).show();
                               Intent intent = new Intent(StudentLogin.this, StudentDashBoard.class);
                               intent.putExtra("std_name",currentStudent.getName());
                               intent.putExtra("std_roll",currentStudent.getRoll_no());
                               startActivity(intent);
                               finish();
                               return;
                           } else{
                               Toast.makeText(StudentLogin.this,"You Entered wrong password",Toast.LENGTH_LONG).show();
                               return;
                           }
                       }
                   }
                }
                Toast.makeText(StudentLogin.this,"Login Failed",Toast.LENGTH_LONG).show();
            }
        });
        studentViewModel.getStudentList().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                studentList = students;
            }
        });


    }

    private void autoLogin(){
        int check_roll = sharedPreferences.getInt("student_roll", -1);
        if(check_roll != -1) {
            String check_password = sharedPreferences.getString("student_password", null);
            if(check_password != null) {
                String check_name = sharedPreferences.getString("student_name","Random Name");
                Toast.makeText(StudentLogin.this,"Hello "+check_name,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(StudentLogin.this, StudentDashBoard.class);
                intent.putExtra("std_name",check_name);
                intent.putExtra("std_roll",check_roll);
                startActivity(intent);
                finish();
                return;
            }
        }
    }
}