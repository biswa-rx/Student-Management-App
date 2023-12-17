package com.example.studentmanagement.data.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.studentmanagement.data.mapper.TeacherMapper;
import com.example.studentmanagement.data.remote.TeacherApiService;
import com.example.studentmanagement.data.remote.dto.TeacherDto;
import com.example.studentmanagement.domain.model.Teacher;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeacherRepository {

    private MutableLiveData<List<Teacher>> _teacherList = new MutableLiveData<>();

    public LiveData<List<Teacher>> getTeacherList() {
        return _teacherList;
    }
    TeacherApiService teacherApiService;
    Context applicationContext;

    public TeacherRepository(
            TeacherApiService teacherApiService,
            Context applicationContext
    ){
        this.teacherApiService = teacherApiService;
        this.applicationContext = applicationContext;
    }

    public void getTeacherFromRemote() {
        List<Teacher> teacherList = new ArrayList<>();
        teacherApiService.getAllTeacher().enqueue(new Callback<List<TeacherDto>>() {
            @Override
            public void onResponse(Call<List<TeacherDto>> call, Response<List<TeacherDto>> response) {
                List<TeacherDto> teacherDtos = response.body();

                if(teacherDtos == null){
                    return;
                }
                for (int i = 0;i<teacherDtos.size();i++){
                    teacherList.add(TeacherMapper.TeacherDtoToStudent(teacherDtos.get(i)));
                }
                _teacherList.setValue(teacherList);
            }

            @Override
            public void onFailure(Call<List<TeacherDto>> call, Throwable t) {

            }
        });

    }

}
