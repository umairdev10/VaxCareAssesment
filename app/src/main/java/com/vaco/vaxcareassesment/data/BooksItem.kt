package com.vaco.vaxcareassesment.data

import com.google.gson.Gson
import com.vaco.vaxcareassesment.data.local.Book

data class BooksItem(
    val author: String,
    val fee: Double,
    val id: Int,
    val lastEdited: String,
    val status: Status? = null,
    val title: String
) {
    fun toDao(): Book {
        return Book(
            bookId = id,
            author = author,
            fee = fee,
            lastEdited = lastEdited,
            title = title,
            displayText = status?.displayText ?: "",
            dueDate = status?.dueDate ?: "",
            id = status?.id ?: 0,
            timeCheckedIn = status?.timeCheckedIn ?: "",
            timeCheckedOut = status?.timeCheckedOut ?: ""
        )
    }
}