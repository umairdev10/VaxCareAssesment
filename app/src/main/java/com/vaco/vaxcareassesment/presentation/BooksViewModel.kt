package com.vaco.vaxcareassesment.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vaco.vaxcareassesment.common.Resource
import com.vaco.vaxcareassesment.domain.usecase.GetBooksUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(val usecase: GetBooksUsecase) : ViewModel() {

    private val _state = mutableStateOf(BooksState())
    val state: State<BooksState> = _state

    init {
        getBooks()
    }

    fun getBooks() {
        viewModelScope.launch {
            if (usecase.getBooks().isNotEmpty())
                _state.value = BooksState(books = usecase.getBooks())
            else
                refreshBooks()
        }
    }

    fun refreshBooks() {
        _state.value = BooksState(loading = true)
        usecase.refreshBooks().onEach { result ->
            when (result) {
                is Resource.Error -> _state.value = BooksState()
                is Resource.Loading -> _state.value = BooksState(loading = true)
                is Resource.Success -> {
                    result.data?.let { books ->
                        usecase.clearBooks()
                        usecase.insertBooks(books.map { it.toDao() })
                        getBooks()
                    }
                }
            }
        }.launchIn(viewModelScope)
    }
}