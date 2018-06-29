package com.room.jetpack.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.room.jetpack.R;
import com.room.jetpack.entities.Student;

import java.util.List;

/**
 * Created by Pravesh Sharma on 19-06-2018.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.studentViewHolder> {

    LayoutInflater mInflater;
    List<Student> studentList;

    public StudentAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public studentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new studentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(studentViewHolder holder, int position) {
        if (studentList != null) {
            Student student = studentList.get(position);
            holder.txtStudent.setText(student.toString());
        } else {
            holder.txtStudent.setText("No Students are registered");
        }
    }

    @Override
    public int getItemCount() {
        if (studentList != null)
            return studentList.size();
        else return 0;
    }

    public void updateStudents(List<Student> students) {
        studentList=students;
        notifyDataSetChanged();
    }

    public Student getStudentOnPos(int pos){
       return studentList.get(pos);
    }

    public static class studentViewHolder extends RecyclerView.ViewHolder {

        private TextView txtStudent;

        public studentViewHolder(View itemView) {
            super(itemView);
            txtStudent = itemView.findViewById(R.id.textView);
        }
    }


}
