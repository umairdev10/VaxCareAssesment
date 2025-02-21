package com.vaco.vaxcareassesment.data.repository

import com.vaco.vaxcareassesment.data.Books
import com.vaco.vaxcareassesment.data.local.Book
import com.vaco.vaxcareassesment.data.local.BookDAO
import com.vaco.vaxcareassesment.data.remote.ApiInterface
import com.vaco.vaxcareassesment.domain.repository.BooksRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BooksRepositoryImpl @Inject constructor(
    private val apiInterface: ApiInterface,
    private val bookDAO: BookDAO
) : BooksRepository {
    override suspend fun getBookById(bookId: Int): Book {
        return withContext(Dispatchers.IO) {
            bookDAO.getBookById(bookId)
        }
    }

    override suspend fun clearBooks() {
        withContext(Dispatchers.IO) {
            bookDAO.clearBooks()
        }
    }

    override suspend fun insertBook(books: List<Book>) {
        withContext(Dispatchers.IO) {
            bookDAO.insertBooks(books)
        }
    }

    override suspend fun getBooks(): List<Book> {
        return withContext(Dispatchers.IO) {
            bookDAO.getAllBooks()
        }
    }

    override suspend fun refreshBooks(): Books {
        return apiInterface.getBooks()
    }
}