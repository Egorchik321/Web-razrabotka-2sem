package com.example.movie_api.contollers

import com.example.movie_api.dtos.LoginDTO
import com.example.movie_api.dtos.Message
import com.example.movie_api.dtos.RegisterDTO
import com.example.movie_api.models.Person
import com.example.movie_api.services.UserService
import io.jsonwebtoken.Jwts

import io.jsonwebtoken.SignatureAlgorithm
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletResponse
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
@RequestMapping("user")
class AuthController(private val userService: UserService) {
    @PostMapping("register")
    fun register(@Valid @RequestBody body: RegisterDTO, bindingResult: BindingResult): ResponseEntity<*> {
        if (bindingResult.hasErrors()) {
            val errors = bindingResult.fieldErrors.associate { it.field to it.defaultMessage!! }
            return ResponseEntity.badRequest().body(errors)
        }
        val person = Person()
        person.name = body.name
        person.email = body.email
        person.password = body.password

        return ResponseEntity.ok(this.userService.save(person))
    }

    @PostMapping("login")
    fun login(@Valid @RequestBody body: LoginDTO, bindingResult: BindingResult, response: HttpServletResponse): ResponseEntity<*> {
        if (bindingResult.hasErrors()) {
            val errors = bindingResult.fieldErrors.associate { it.field to it.defaultMessage!! }
            return ResponseEntity.badRequest().body(errors)
        }
        val user = this.userService.findByEmail(body.email)
            ?: return ResponseEntity.badRequest().body(Message("user not found!"))

        if (!user.comparePassword(body.password)) return ResponseEntity.badRequest().body(Message("invalid password!"))

        val issuer = user.id.toString()
        val jwt = Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis() + 60 * 24 * 1000)) // 1 day
            .signWith(SignatureAlgorithm.HS512, "secret").compact()

        response.addCookie(Cookie("jwt", jwt).apply { isHttpOnly = true })

        return ResponseEntity.ok(Message("success"))
    }
}