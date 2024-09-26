package com.example.movie_api.dtos

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class RegisterDTO(
    @field: NotBlank(message = "The field is required")
    val name: String,

    @field: NotBlank(message = "The field is required")
    @field: Email(message = "Incorrect email")
    val email: String,

    @field: NotBlank(message = "The field is required")
    @field: Size(min = 6, max = 12, message = "Password should be between 6 and 12 characters")
    val password: String,
)
