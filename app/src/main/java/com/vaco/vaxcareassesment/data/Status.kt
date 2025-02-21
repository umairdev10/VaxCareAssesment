package com.vaco.vaxcareassesment.data

data class Status(
    val displayText: String,
    val dueDate: String,
    val id: Int,
    val timeCheckedIn: String,
    val timeCheckedOut: String
)