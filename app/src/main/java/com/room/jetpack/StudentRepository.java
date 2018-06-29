package com.room.jetpack;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.room.jetpack.async.GenericAsynTask;
import com.room.jetpack.dao.StudentDao;
import com.room.jetpack.database.StudentDatabase;
import com.room.jetpack.entities.Student;

import java.util.List;

/**
 * Created by Pravesh Sharma on 19-06-2018.
 */

public class StudentRepository {

    private StudentDao mStudentDao;
    private LiveData<List<Student>> mAllStudents;

    public StudentRepository(Application application) {
        StudentDatabase db = StudentDatabase.getDatabaseInstance(application);
        mStudentDao = db.mStudentDao();
        mAllStudents = mStudentDao.getAllStudents();
    }

    public LiveData<List<Student>> getAllStudents() {
        return mAllStudents;
    }

    public void insertStudent(Student mStudent) {
        GenericAsynTask<Student> genericAsynTask = new GenericAsynTask<>();
        genericAsynTask.setCallbackListener(new GenericAsynTask.AsyncCallback<Student>() {
            @Override
            public void databaseAction(Student args) {
                mStudentDao.registerStudent(args);
            }
        });

        genericAsynTask.execute(mStudent);

    }


    public void deleteStudent(final Student student) {
        GenericAsynTask<Student> genericAsynTask = new GenericAsynTask<>();
        genericAsynTask.setCallbackListener(new GenericAsynTask.AsyncCallback<Student>() {
            @Override
            public void databaseAction(Student args) {
                mStudentDao.deleteStudent(args);
            }
        });

        genericAsynTask.execute(student);
    }

}