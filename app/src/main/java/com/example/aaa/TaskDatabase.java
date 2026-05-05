package com.example.aaa;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Task.class}, version = 2)
public abstract class TaskDatabase extends RoomDatabase {
    public static TaskDatabase Tdatabase;
    public abstract TaskDAO taskDao();

    public static synchronized TaskDatabase getInstance(Context context) {
        if (Tdatabase == null) {
            Tdatabase = Room.databaseBuilder(context.getApplicationContext(),
                            TaskDatabase.class, "TaskDatabase")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return Tdatabase;
    }
}
