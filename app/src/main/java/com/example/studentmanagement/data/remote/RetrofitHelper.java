package com.example.studentmanagement.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    private static RetrofitHelper instance = null;
    public static final String BASE_URL = "http://192.168.4.137:3000/";

    // Keep your services here, build them in buildRetrofit method later
    private StudentApiService studentService;
    private TeacherApiService teacherApiService;

    public static RetrofitHelper getInstance() {
        if (instance == null) {
            instance = new RetrofitHelper();
        }

        return instance;
    }

    // Build retrofit once when creating a single instance
    private RetrofitHelper() {
        // Implement a method to build your retrofit
        buildRetrofit(BASE_URL);
    }

    private void buildRetrofit(String BASE_URL) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Build your services once
        this.studentService = retrofit.create(StudentApiService.class);
    }

    public StudentApiService getStudentService() {
        return this.studentService;
    }
    public TeacherApiService getTeacherApiService() {
        return this.teacherApiService;
    }
}
