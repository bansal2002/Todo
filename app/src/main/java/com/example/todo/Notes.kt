package com.example.todo

import androidx.room.*

@Entity(tableName = "notes_table")
class Notes(@ColumnInfo(name = "text") val text:String) {
    @PrimaryKey(autoGenerate = true) var id = 0
}


