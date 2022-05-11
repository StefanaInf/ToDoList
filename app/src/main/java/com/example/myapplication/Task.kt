package com.example.myapplication;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tasksTable")
class Task (
    @ColumnInfo(name = "name") val taskTitle: String,
    @ColumnInfo(name = "type") val taskType: String,
    @ColumnInfo(name = "status") val taskStatus: String,
    @ColumnInfo(name = "description") val taskDescription: String,
    @ColumnInfo(name = "dueDate") val taskDueDate: String
) {
    @PrimaryKey(autoGenerate = true)
    var taskId = 0
}
