package com.room.jetpack;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.room.jetpack.adapters.StudentAdapter;
import com.room.jetpack.entities.Student;
import com.room.jetpack.utility.util;
import com.room.jetpack.viewmodels.StudentViewModel;
import com.room.jetpack.widgets.RecyclerTouchListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.internal.Utils;

public class ShowStudentsActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerStudent)
    RecyclerView recyclerStudent;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    private StudentViewModel studentViewModel;
    private static final int STUDENT_REGISTERED_RESULT_CODE = 1;
    private static final int STUDENT_DELETED_RESULT_CODE = 2;

    private StudentAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_students);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        setRecyclerClicks();
        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);
        showStudents();
        registrationObserver();


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowStudentsActivity.this, RegisterStudentActivity.class);
                startActivityForResult(intent, STUDENT_REGISTERED_RESULT_CODE);
            }
        });
    }


    private void registrationObserver() {
        studentViewModel.getAllStudents().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(@Nullable List<Student> students) {
                adapter.updateStudents(students);
            }
        });
    }


    private void showStudents() {
        adapter = new StudentAdapter(this);
        recyclerStudent.setAdapter(adapter);
        recyclerStudent.setLayoutManager(new LinearLayoutManager(this));
    }


    void setRecyclerClicks() {

        recyclerStudent.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerStudent, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(ShowStudentsActivity.this, "Single Click on position:" + position,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v.vibrate(100);
                showDeleteConfirmationDialog(position);
            }
        }));
    }

    private void showDeleteConfirmationDialog(final int position) {
        util.showDialog(this, "Delete", "Are you sure you want to delete the student?", new util.dialogClickListener() {
            @Override
            public void okCallback(boolean ok) {
                if (ok) {
                    studentViewModel.deleteStudent(adapter.getStudentOnPos(position));
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == STUDENT_REGISTERED_RESULT_CODE && resultCode == RESULT_OK) {
            if (data != null && data.hasExtra(RegisterStudentActivity.REPLY_EXTRA)) {
                Student student;
                student = (Student) data.getSerializableExtra(RegisterStudentActivity.REPLY_EXTRA);
                studentViewModel.insert(student);

            }

        }
    }
}
