package com.vaco.vaxcareassesment.domain.usecase

import com.vaco.vaxcareassesment.common.Resource
import com.vaco.vaxcareassesment.data.Books
import com.vaco.vaxcareassesment.data.local.Book
import com.vaco.vaxcareassesment.domain.repository.BooksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetBooksUsecase @Inject constructor(private val repository: BooksRepository) {
    fun refreshBooks(): Flow<Resource<Books>> = flow {
        try {
            emit(Resource.Loading())
            val result = repository.refreshBooks()
            emit(Resource.Success(result))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message ?: "unexpected error"))
        }
    }

    suspend fun getBooks(): List<Book> {
        return repository.getBooks()
    }

    suspend fun insertBooks(books: List<Book>) {
        repository.insertBook(books)
    }

    suspend fun clearBooks() {
        repository.clearBooks()
    }

    suspend fun getBookById(bookId: Int): Book {
        return repository.getBookById(bookId)
    }
}