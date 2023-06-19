package com.example.movie_api.repositories

import com.example.movie_api.models.Movie
import org.springframework.data.jpa.repository.JpaRepository

interface MovieRepository: JpaRepository<Movie, Int> {
    fun findByTitle(title:String): List<Movie>?
    fun findByActor(actor:String): List<Movie>?
    fun findByReview(review: String): List<Movie>?
    fun findByPlot(plot: String): Movie?
}