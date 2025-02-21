package com.vaco.vaxcareassesment.presentation

import com.vaco.vaxcareassesment.data.local.Book

data class BooksState(val loading: Boolean? = false, val books: List<Book>? = emptyList())