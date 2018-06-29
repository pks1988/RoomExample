package com.room.jetpack.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.room.jetpack.dao.StudentDao;
import com.room.jetpack.entities.Student;

/**
 * Created by Pravesh Sharma on 19-06-2018.
 */

@Database(entities = {Student.class}, version = 1)
public abstract class StudentDatabase extends RoomDatabase {

    private static StudentDatabase databaseInDatabase;

    public abstract StudentDao mStudentDao();


    public static StudentDatabase getDatabaseInstance(final Context mContext) {
        if (databaseInDatabase == null) {
            synchronized (StudentDatabase.class) {
                databaseInDatabase = Room.databaseBuilder(mContext.getApplicationContext(), StudentDatabase.class, "student_database")
                        .build();
            }
        }
        return databaseInDatabase;
    }
}
