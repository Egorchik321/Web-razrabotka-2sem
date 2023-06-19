package com.example.book_api.contollers

import com.example.book_api.models.Book
import com.example.book_api.services.BookService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("books")
class BookController(private val bookService: BookService) {

    @GetMapping
    fun searchByTitle(@RequestParam title: String): ResponseEntity<List<Book>> {
        return ResponseEntity.ok(this.bookService.findByTitle(title))
    }

    @GetMapping("search")
    fun searchByIsbn(@RequestParam isbn: String): ResponseEntity<Book> {
        return ResponseEntity.ok(this.bookService.findByIsbn(isbn))
    }

    @GetMapping("author")
    fun searchByAuthor(@RequestParam author: String): ResponseEntity<List<Book>> {
        return ResponseEntity.ok(this.bookService.findByAuthor(author))
    }

    @GetMapping("genre")
    fun searchByGenre(@RequestParam genre: String): ResponseEntity<List<Book>> {
        return ResponseEntity.ok(this.bookService.findByGenre(genre))
    }
}