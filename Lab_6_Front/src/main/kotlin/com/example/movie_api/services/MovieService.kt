package com.example.movie_api.services

import com.example.movie_api.models.Movie
import com.example.movie_api.repositories.MovieRepository
import org.springframework.stereotype.Service

@Service
class MovieService(private val movieRepository: MovieRepository) {
    fun findByTitle(title:String): List<Movie>? = movieRepository.findByTitle(title)
    fun findByActor(actor:String): List<Movie>? = movieRepository.findByActor(actor)
    fun findByReview(review: String): List<Movie>? = movieRepository.findByReview(review)
    fun findByPlot(plot: String): Movie? = movieRepository.findByPlot(plot)
}