package com.example.mymusic;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DaoAccess {

    @Insert
    long insertTodo(Todo todo);
    @Insert
    long insertTodo2(Todo2 todo2);
    @Insert
    long insertTodo3(Todo2 todo2);

    @Insert
    void insertTodoList(List<Todo> todoList);

    @Insert
    void insertTodoList2(List<Todo2> todoList2);


    @Query("SELECT * FROM " + MyDatabase.TABLE_NAME_TODO)
    List<Todo> fetchAllTodos();

    @Query("SELECT * FROM " + MyDatabase.TABLE_NAME_TODO2)
    List<Todo2> fetchAllTodos2();


    @Query("SELECT category FROM " + MyDatabase.TABLE_NAME_TODO2 + " ORDER BY countcat DESC")
    List<String> fetchTodoListByCategory();

    @Query("SELECT artist FROM " + MyDatabase.TABLE_NAME_TODO2 + " ORDER BY countartist ASC")
    List<String> fetchTodoListByartist();

    @Query("SELECT description FROM " + MyDatabase.TABLE_NAME_TODO + " ORDER BY time DESC LIMIT 3")
    List<String> fetchTodoListBytime();




//    @Update
//    int updateTodo2(Todo2 todo2);


    @Query("UPDATE " +MyDatabase.TABLE_NAME_TODO+" SET time=:countcat2 WHERE description = :category2")
    int updateTodo(double countcat2, String category2);


    @Query("UPDATE " +MyDatabase.TABLE_NAME_TODO2+" SET countcat=:countcat2 WHERE category = :category2")
    int updateTodo2(double countcat2, String category2);

    @Query("UPDATE " +MyDatabase.TABLE_NAME_TODO2+" SET countartist=:countartist WHERE artist = :artist")
    int updateTodo3(double countartist, String artist);


    @Delete
    int deleteTodo(Todo todo);

    @Delete
    int deleteTodo2(Todo2 todo2);


}
