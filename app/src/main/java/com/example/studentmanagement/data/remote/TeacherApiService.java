package com.example.studentmanagement.data.remote;

import com.example.studentmanagement.data.remote.dto.TeacherDto;
import com.example.studentmanagement.domain.model.Teacher;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TeacherApiService {
    @GET("/register_teacher/")
    Call<List<TeacherDto>> getAllTeacher();

    @POST("/register_teacher/")
    Call<TeacherDto> createTeacher(@Body Teacher teacher);

    @GET("/register_teacher/{id}")
    Call<TeacherDto> getTeacherById(@Path("id") String id);

    @PATCH("/register_teacher/{id}")
    Call<TeacherDto> updateTeacherById(@Path("id") String id,@Body Teacher teacher);

    @DELETE("/register_teacher/{id}")
    Call<TeacherDto> deleteTeacherById(@Path("id") String id);
}
