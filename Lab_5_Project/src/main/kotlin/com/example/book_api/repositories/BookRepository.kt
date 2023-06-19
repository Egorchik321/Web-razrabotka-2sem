package com.example.book_api.repositories

import com.example.book_api.models.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository: JpaRepository<Book, Int> {
    fun findByTitle(title:String): List<Book>?
    fun findByAuthor(author:String): List<Book>?
    fun findByGenre(genre: String): List<Book>?
    fun findByIsbn(isbn: String): Book?
}