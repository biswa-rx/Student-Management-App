package com.example.studentmanagement.presentation.admin;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.studentmanagement.data.repository.StudentRepository;
import com.example.studentmanagement.data.repository.TeacherRepository;

public class AdminViewModelFactory implements ViewModelProvider.Factory {
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public AdminViewModelFactory(StudentRepository studentRepository,TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(AdminViewModel.class)) {
            //noinspection unchecked
            return (T) new AdminViewModel(teacherRepository,studentRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
