package com.example.studentmanagement.data.mapper;

import com.example.studentmanagement.data.remote.dto.StudentDto;
import com.example.studentmanagement.domain.model.Student;

public class StudentMapper {

    public static Student StudentDtoToStudent(StudentDto studentDto){
        return new Student(studentDto.getId(), studentDto.getName(),studentDto.getRoll_no(),studentDto.getPassword());
    }
}
