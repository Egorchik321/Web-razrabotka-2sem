package com.example.book_api.models

import jakarta.persistence.*


@Entity
@Table(name = "book")
data class Book (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val title: String,
    val author: String,
    val isbn: String,
    val publishedYear: Int,
    val genre: String
)