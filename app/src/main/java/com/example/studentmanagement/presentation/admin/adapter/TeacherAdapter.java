package com.example.studentmanagement.presentation.admin.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentmanagement.R;
import com.example.studentmanagement.domain.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.ViewHolder>{

    List<Teacher> teacherList;
    Context context;

    public TeacherAdapter(List<Teacher> teacherList, Context context) {
        this.teacherList = teacherList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_teacher_item_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.teacherName.setText(teacherList.get(position).getName());
        holder.teacherRedgno.setText(teacherList.get(position).getRedg_no());
    }

    @Override
    public int getItemCount() {
        return teacherList == null ? 0 : teacherList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView teacherName,teacherRedgno,teacherQualification;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            teacherName = itemView.findViewById(R.id.item_student_name);
            teacherRedgno = itemView.findViewById(R.id.item_teacher_redgno);
            teacherQualification = itemView.findViewById(R.id.item_teacher_qualification);

        }
    }
    public interface OnStudentClickListener{
        void onItemClick(int position);
    }
}