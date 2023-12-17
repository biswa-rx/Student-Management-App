package com.example.studentmanagement.data.remote;

import com.example.studentmanagement.data.remote.dto.StudentDto;
import com.example.studentmanagement.domain.model.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface StudentApiService {
    @GET("/register_student/")
    Call<List<StudentDto>> getAllStudent();

    @POST("/register_student/")
    Call<StudentDto> createStudent(@Body Student student);

    @GET("/register_student/{id}")
    Call<StudentDto> getStudentById(@Path("id") String id);

    @PATCH("/register_student/{id}")
    Call<StudentDto> updateStudentById(@Path("id") String id,@Body Student student);

    @DELETE("/register_student/{id}")
    Call<StudentDto> deleteStudentById(@Path("id") String id);
}
