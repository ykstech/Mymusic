package com.example.mymusic;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Todo.class,Todo2.class}, version = 1, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {

    public static final String DB_NAME = "app_db";
    public static final String TABLE_NAME_TODO = "todo";

    public static final String TABLE_NAME_TODO2 = "todo2";

    public abstract DaoAccess daoAccess();

}


