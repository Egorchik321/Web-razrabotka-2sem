package com.example.movie_api.dtos

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class LoginDTO(
    @field: NotBlank(message = "The field is required")
    @field: Email(message = "Incorrect email")
    val email: String = "",

    @field: NotBlank(message = "The field is required")
    val password: String = ""
)