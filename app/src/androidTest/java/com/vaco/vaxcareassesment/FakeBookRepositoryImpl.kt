package com.vaco.vaxcareassesment

import com.vaco.vaxcareassesment.data.Books
import com.vaco.vaxcareassesment.data.local.Book
import com.vaco.vaxcareassesment.domain.repository.BooksRepository

class FakeBookRepositoryImpl : BooksRepository {
    override suspend fun getBookById(bookId: Int): Book {
        return Book(
            1,
            fee = 2.0,
            title = "Book 1",
            author = "Author 1",
            displayText = "Shelf A",
            lastEdited = "",
            id = 0,
            timeCheckedIn = "",
            timeCheckedOut = "",
            dueDate = ""
        )
    }

    override suspend fun clearBooks() {
    }

    override suspend fun insertBook(books: List<Book>) {

    }

    override suspend fun getBooks(): List<Book> {
        return listOf(
            Book(
                1,
                fee = 2.0,
                title = "Book 1",
                author = "Author 1",
                displayText = "Shelf A",
                lastEdited = "",
                id = 0,
                timeCheckedIn = "",
                timeCheckedOut = "",
                dueDate = ""
            ),
            Book(
                2,
                fee = 2.0,
                title = "Book 2",
                author = "Author 2",
                displayText = "Shelf B",
                lastEdited = "",
                id = 0,
                timeCheckedIn = "",
                timeCheckedOut = "",
                dueDate = ""
            )
        )
    }

    override suspend fun refreshBooks(): Books {
        return Books()
    }
}