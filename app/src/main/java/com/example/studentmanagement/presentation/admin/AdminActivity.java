package com.example.studentmanagement.presentation.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.studentmanagement.R;
import com.example.studentmanagement.domain.model.Student;
import com.example.studentmanagement.domain.model.Teacher;
import com.example.studentmanagement.presentation.StudentManagementApplication;
import com.example.studentmanagement.presentation.admin.adapter.StudentAdapter;
import com.example.studentmanagement.presentation.admin.adapter.TeacherAdapter;
import com.example.studentmanagement.presentation.student.StudentViewModel;
import com.example.studentmanagement.presentation.student.StudentViewModelFactory;

import java.util.List;

public class AdminActivity extends AppCompatActivity {

    AdminViewModel adminViewModel;
    RecyclerView teacherListRv,studentListRv;
    StudentAdapter studentAdapter;
    TeacherAdapter teacherAdapter;
    List<Student> studentList;
    List<Teacher> teacherList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        teacherListRv = findViewById(R.id.teacher_list_rv);
        studentListRv = findViewById(R.id.student_list_rv);
        adminViewModel = new ViewModelProvider(
                this,new AdminViewModelFactory(
                        StudentManagementApplication.studentRepository, StudentManagementApplication.teacherRepository
        )
        ).get(AdminViewModel.class);

        adminViewModel.getStudentList().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                studentList = students;
                setupRecyclerView();
                System.out.println(studentList.toString());
            }
        });

        adminViewModel.getTeacherList().observe(this, new Observer<List<Teacher>>() {
            @Override
            public void onChanged(List<Teacher> teachers) {
                teacherList = teachers;
//                setupRecyclerView();
                System.out.println(teacherList.toString());
            }
        });

    }

    private void setupRecyclerView() {
//        teacherAdapter = new TeacherAdapter(teacherList,this);
        studentAdapter = new StudentAdapter(studentList,this);
//
//        teacherListRv.setLayoutManager(new LinearLayoutManager(this));
//        teacherListRv.setAdapter(teacherAdapter);
        studentListRv.setLayoutManager(new LinearLayoutManager(this));
        studentListRv.setAdapter(studentAdapter);
//
    }
}