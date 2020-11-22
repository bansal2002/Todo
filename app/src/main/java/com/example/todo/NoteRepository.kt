package com.example.todo

import androidx.lifecycle.LiveData

class NoteRepository(private val noteDao:NotesDao) {

    val allNotes: LiveData<List<Notes>> = noteDao.getAllData()

    suspend fun insert(note: Notes){
        noteDao.insert(note)
    }

    suspend fun delete(note: Notes){
        noteDao.delete(note)
    }
}