package com.vaco.vaxcareassesment.domain.repository

import com.vaco.vaxcareassesment.data.Books
import com.vaco.vaxcareassesment.data.local.Book
import kotlinx.coroutines.flow.Flow

interface BooksRepository {
    suspend fun getBookById(bookId:Int) : Book
    suspend fun clearBooks()
    suspend fun insertBook(books:List<Book>)
    suspend fun getBooks():List<Book>
    suspend fun refreshBooks() : Books
}