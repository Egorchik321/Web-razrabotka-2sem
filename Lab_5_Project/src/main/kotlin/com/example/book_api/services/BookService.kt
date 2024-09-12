package com.example.book_api.services

import com.example.book_api.models.Book
import com.example.book_api.repositories.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(private val bookRepository: BookRepository) {
    fun findByTitle(title:String): List<Book>? = bookRepository.findByTitle(title)
    fun findByAuthor(author:String): List<Book>? = bookRepository.findByAuthor(author)
    fun findByGenre(genre: String): List<Book>? = bookRepository.findByGenre(genre)
    fun findByIsbn(isbn: String): Book? = bookRepository.findByIsbn(isbn)
}