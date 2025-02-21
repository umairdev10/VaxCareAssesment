package com.vaco.vaxcareassesment.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class Book(
    @PrimaryKey  val bookId: Int,
    val author: String,
    val fee: Double,
    val lastEdited: String,
    val title: String,
    val displayText: String,
    val dueDate: String,
    val id: Int,
    val timeCheckedIn: String,
    val timeCheckedOut: String
)