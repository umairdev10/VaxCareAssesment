package com.vaco.vaxcareassesment.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDAO {
    @Query("Select * From books")
    fun getAllBooks() : List<Book>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBooks(books:List<Book>)

    @Query("DELETE FROM books")
    suspend fun clearBooks()


    @Query("SELECT * FROM books WHERE bookId = :bookId")
    fun getBookById(bookId: Int): Book
}