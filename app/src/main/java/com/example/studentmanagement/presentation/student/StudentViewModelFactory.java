package com.example.studentmanagement.presentation.student;


import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.studentmanagement.data.repository.StudentRepository;

public class StudentViewModelFactory implements ViewModelProvider.Factory {
    private final StudentRepository studentRepository;

    public StudentViewModelFactory(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(StudentViewModel.class)) {
            //noinspection unchecked
            return (T) new StudentViewModel(studentRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
