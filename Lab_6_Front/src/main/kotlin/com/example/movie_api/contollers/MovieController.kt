package com.example.movie_api.contollers

import com.example.movie_api.models.Movie
import com.example.movie_api.services.MovieService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("movie")
class MovieController(private val movieService: MovieService) {

    @GetMapping
    fun searchByTitle(@RequestParam title: String): ResponseEntity<List<Movie>> {
        return ResponseEntity.ok(this.movieService.findByTitle(title))
    }

    @GetMapping("search")
    fun searchByIsbn(@RequestParam plot: String): ResponseEntity<Movie> {
        return ResponseEntity.ok(this.movieService.findByPlot(plot))
    }

    @GetMapping("actor")
    fun searchByAuthor(@RequestParam actor: String): ResponseEntity<List<Movie>> {
        return ResponseEntity.ok(this.movieService.findByActor(actor))
    }

    @GetMapping("review")
    fun searchByGenre(@RequestParam review: String): ResponseEntity<List<Movie>> {
        return ResponseEntity.ok(this.movieService.findByReview(review))
    }
}