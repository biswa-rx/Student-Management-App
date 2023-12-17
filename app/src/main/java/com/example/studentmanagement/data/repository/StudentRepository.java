package com.example.studentmanagement.data.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.studentmanagement.data.mapper.StudentMapper;
import com.example.studentmanagement.data.remote.StudentApiService;
import com.example.studentmanagement.data.remote.dto.StudentDto;
import com.example.studentmanagement.domain.model.Student;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class StudentRepository {

    private MutableLiveData<List<Student>> _studentList = new MutableLiveData<>();

    public LiveData<List<Student>> getStudentList() {
        return _studentList;
    }
    StudentApiService  studentApiService;
    Context applicationContext;

    public StudentRepository(
            StudentApiService studentApiService,
            Context applicationContext
    ){
        this.studentApiService = studentApiService;
        this.applicationContext = applicationContext;
    }

    public void getStudentFromRemote() {
        List<Student> studentList = new ArrayList<>();
        studentApiService.getAllStudent().enqueue(new Callback<List<StudentDto>>() {
            @Override
            public void onResponse(Call<List<StudentDto>> call, Response<List<StudentDto>> response) {
                List<StudentDto> studentDto = response.body();

                if(studentDto == null){
                    return;
                }
                for (int i = 0;i<studentDto.size();i++){
                    studentList.add(StudentMapper.StudentDtoToStudent(studentDto.get(i)));
                }
                _studentList.setValue(studentList);
            }

            @Override
            public void onFailure(Call<List<StudentDto>> call, Throwable t) {

            }
        });

    }

    public void addNewStudent(Student student) {
        studentApiService.createStudent(student).enqueue(new Callback<StudentDto>() {
            @Override
            public void onResponse(Call<StudentDto> call, Response<StudentDto> response) {
                assert response.body() != null;
                System.out.println(response.body().getName());
            }

            @Override
            public void onFailure(Call<StudentDto> call, Throwable t) {

            }
        });
    }


}
