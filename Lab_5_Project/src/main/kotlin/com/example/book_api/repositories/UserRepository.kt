package com.example.book_api.repositories

import com.example.book_api.models.Person
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<Person, Int> {
    fun findByEmail(email:String): Person?
}