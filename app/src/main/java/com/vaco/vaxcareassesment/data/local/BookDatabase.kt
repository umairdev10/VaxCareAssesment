package com.vaco.vaxcareassesment.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Book::class], version = 1, exportSchema = false)
abstract class BookDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDAO

    companion object {
       const val DATABASE_NAME = "book_db"
    }
}