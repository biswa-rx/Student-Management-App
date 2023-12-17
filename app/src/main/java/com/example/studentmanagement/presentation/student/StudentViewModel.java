package com.example.studentmanagement.presentation.student;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.studentmanagement.data.repository.StudentRepository;
import com.example.studentmanagement.domain.model.Student;

import java.util.List;

public class StudentViewModel extends ViewModel {

    StudentRepository studentRepository;
    public StudentViewModel(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public LiveData<List<Student>> getStudentList() {
        studentRepository.getStudentFromRemote();
        return studentRepository.getStudentList();
    }

}
