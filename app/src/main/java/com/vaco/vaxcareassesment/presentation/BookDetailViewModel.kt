package com.vaco.vaxcareassesment.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.vaco.vaxcareassesment.domain.usecase.GetBooksUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookDetailViewModel @Inject constructor(savedStateHandle: SavedStateHandle, val usecase: GetBooksUsecase) :
    ViewModel() {

    val bookDetail = savedStateHandle.toRoute<BookDetailScreen>()
    private val _state = mutableStateOf(BookDetailState())
    val state = _state

    init {
        getBookById()
    }

    fun getBookById() {
        viewModelScope.launch {
            _state.value = BookDetailState(usecase.getBookById(bookDetail.bookId))
        }
    }
}