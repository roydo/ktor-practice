package com.example.roots

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.module2() {
    routing {
        get("/about") {
            val path = call.request.path()
            call.respondText("Path: $path")
        }
        get("/about/contact") {
            val path = call.request.path()
            call.respondText("Path: $path")
        }
    }
}