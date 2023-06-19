package com.example.movie_api.models

import jakarta.persistence.*


@Entity
@Table(name = "movie")
data class Movie (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val title: String,
    val actor: String,
    val review: String,
    val plot: String
)