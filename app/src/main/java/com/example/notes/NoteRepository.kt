package com.example.notes

import androidx.lifecycle.LiveData

class NoteRepository(private val noteDao: NoteDao) {
    //repository for fetching data from all sources either online/offline (just a layer)
    val allNotes:LiveData<List<Note>> = noteDao.getAllNote()

    suspend fun insert (note: Note){
        noteDao.insert(note)
    }
    suspend fun delete(note: Note){
        noteDao.delete(note)
    }
//    ..vieewmodels helps in config changes /data holder as data can be lost when activity restarts on changing congif
    //it also provides acti the data when needed
}