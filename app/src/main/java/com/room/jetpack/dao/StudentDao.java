package com.room.jetpack.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.room.jetpack.entities.Student;

import java.util.List;

/**
 * Created by Pravesh Sharma on 19-06-2018.
 */

@Dao
public interface StudentDao {

    @Insert
    void registerStudent(Student student);

    @Query("Select * from STUDENT_REGISTRATION ORDER BY studentId")
    LiveData<List<Student>> getAllStudents();

    @Delete
    void deleteStudent(Student student);

}
