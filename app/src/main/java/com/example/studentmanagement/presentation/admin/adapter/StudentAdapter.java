package com.example.studentmanagement.presentation.admin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentmanagement.R;
import com.example.studentmanagement.domain.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder>{

    List<Student> studentList;
    Context context;

    public StudentAdapter(List<Student> studentList, Context context) {
        this.studentList = studentList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_student_item_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.studentName.setText(studentList.get(position).getName());
        int rollNo = studentList.get(position).getRoll_no();
        holder.studentRoll.setText(String.valueOf(rollNo));
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView studentName,studentRoll,studentAttadance;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            studentName = itemView.findViewById(R.id.item_student_name);
            studentRoll = itemView.findViewById(R.id.item_student_rollno);
            studentAttadance = itemView.findViewById(R.id.student_score);

        }
    }
    public interface OnStudentClickListener{
        void onItemClick(int position);
    }
}

