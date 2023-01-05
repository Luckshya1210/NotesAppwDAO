package com.example.notes
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)             //same items ignore while inserting
    suspend fun insert(note:Note)

    @Delete
    suspend fun delete(note:Note)

    @Query("Select *from notes_table order by id ASC")
    fun getAllNote():LiveData<List<Note>>
    //livedata can be observed when updated
}

