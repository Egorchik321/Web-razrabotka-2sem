package com.example.movie_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class MovieApiApplication

fun main(args: Array<String>) {
    runApplication<MovieApiApplication>(*args)
}
