package com.example.studentmanagement.data.mapper;

import com.example.studentmanagement.data.remote.dto.StudentDto;
import com.example.studentmanagement.data.remote.dto.TeacherDto;
import com.example.studentmanagement.domain.model.Student;
import com.example.studentmanagement.domain.model.Teacher;

public class TeacherMapper {
    public static Teacher TeacherDtoToStudent(TeacherDto teacherDto){
        return new Teacher(teacherDto.getId(), teacherDto.getName(),teacherDto.getRedg_no(),teacherDto.getPassword());
    }
}
