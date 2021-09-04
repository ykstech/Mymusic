package com.example.mymusic;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = MyDatabase.TABLE_NAME_TODO2)
public class Todo2 implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int todo_id;


    public String category;
    public double countcat;
    public String artist;

    public int countartist;

//
//    public String time;
//
//
//
//    public String category;
//
//
//    public String artist;

    @Ignore
    public String priority;





}
