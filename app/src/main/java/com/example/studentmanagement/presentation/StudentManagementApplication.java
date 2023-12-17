package com.example.studentmanagement.presentation;

import android.app.Application;

import com.example.studentmanagement.data.remote.RetrofitHelper;
import com.example.studentmanagement.data.repository.StudentRepository;
import com.example.studentmanagement.data.repository.TeacherRepository;

public class StudentManagementApplication extends Application {

    public static StudentRepository studentRepository;
    public static TeacherRepository teacherRepository;
    @Override
    public void onCreate() {
        super.onCreate();
        studentRepository = new StudentRepository(RetrofitHelper.getInstance().getStudentService(), getApplicationContext());
        teacherRepository = new TeacherRepository(RetrofitHelper.getInstance().getTeacherApiService(), getApplicationContext());

    }


}
