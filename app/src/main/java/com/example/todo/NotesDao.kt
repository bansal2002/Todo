package com.example.todo

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note:Notes)

    @Delete
    suspend fun delete(note: Notes)

    @Query("Select * From notes_table order by id ASC")
    fun getAllData():LiveData<List<Notes>>
}