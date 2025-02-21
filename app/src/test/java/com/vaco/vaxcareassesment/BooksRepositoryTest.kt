package com.vaco.vaxcareassesment

import com.vaco.vaxcareassesment.data.local.Book
import com.vaco.vaxcareassesment.data.local.BookDAO
import com.vaco.vaxcareassesment.data.remote.ApiInterface
import com.vaco.vaxcareassesment.data.repository.BooksRepositoryImpl
import com.vaco.vaxcareassesment.domain.repository.BooksRepository
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class BooksRepositoryTest {

    private lateinit var repository: BooksRepository
    private val bookDao: BookDAO = mockk()
    private val apiInterface: ApiInterface = mockk()

    @Before
    fun setUp() {
        repository = BooksRepositoryImpl(apiInterface, bookDao)
    }

    @Test
    fun `getBooks returns list of books from DAO`() = runBlocking {
        val fakeBooks = listOf(
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
                displayText = "Shelf A",
                lastEdited = "",
                id = 0,
                timeCheckedIn = "",
                timeCheckedOut = "",
                dueDate = ""
            )
        )
        every { bookDao.getAllBooks() } returns fakeBooks
        val result = repository.getBooks()
        assertNotNull(result)
    }

    @Test
    fun `refreshBooks updates data correctly`() = runBlocking {
        val newBooks = listOf(
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
            )
        )
        coEvery { bookDao.clearBooks() } just Runs
        coEvery { bookDao.insertBooks(newBooks) } just Runs

        repository.clearBooks()
        repository.insertBook(newBooks)
        coVerify(exactly = 1) { bookDao.clearBooks() }
        coVerify(exactly = 1) { bookDao.insertBooks(newBooks) }
    }

    @Test
    fun `getBook returns book by Id from DAO`() = runBlocking {
        val book = Book(
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
        every { bookDao.getBookById(1) } returns book
        val result = repository.getBookById(1)
        assertNotNull(result)
    }
}