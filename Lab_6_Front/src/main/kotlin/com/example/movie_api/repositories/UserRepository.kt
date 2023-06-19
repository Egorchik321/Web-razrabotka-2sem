package com.example.movie_api.repositories

import com.example.movie_api.models.Person
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<Person, Int> {
    fun findByEmail(email:String): Person?
}