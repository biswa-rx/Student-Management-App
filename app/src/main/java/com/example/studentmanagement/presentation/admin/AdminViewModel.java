package com.example.studentmanagement.presentation.admin;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.studentmanagement.data.repository.StudentRepository;
import com.example.studentmanagement.data.repository.TeacherRepository;
import com.example.studentmanagement.domain.model.Student;
import com.example.studentmanagement.domain.model.Teacher;

import java.util.List;

public class AdminViewModel extends ViewModel{
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    public AdminViewModel(TeacherRepository teacherRepository, StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    public LiveData<List<Teacher>> getTeacherList() {
//        teacherRepository.getTeacherFromRemote();
        return teacherRepository.getTeacherList();
    }

    public LiveData<List<Student>> getStudentList() {
        studentRepository.getStudentFromRemote();
        return studentRepository.getStudentList();
    }

    public void addNewStudent(Student student) {
        studentRepository.addNewStudent(student);
    }
}
