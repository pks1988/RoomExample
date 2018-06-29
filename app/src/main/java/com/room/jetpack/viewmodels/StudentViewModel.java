package com.room.jetpack.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.room.jetpack.StudentRepository;
import com.room.jetpack.entities.Student;

import java.util.List;

/**
 * Created by Pravesh Sharma on 19-06-2018.
 */

public class StudentViewModel extends AndroidViewModel {

    private StudentRepository studentRepository;
    private LiveData<List<Student>> mAllStudents;

    public StudentViewModel(Application application) {
        super(application);
        studentRepository = new StudentRepository(application);
        mAllStudents = studentRepository.getAllStudents();
    }

    public LiveData<List<Student>> getAllStudents() {
        return mAllStudents;
    }

    public void insert(Student mStudent) {
        studentRepository.insertStudent(mStudent);
    }

    public void deleteStudent(Student mStudent) {
        studentRepository.deleteStudent(mStudent);
    }


}
