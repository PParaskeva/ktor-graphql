package com.example.kmm.routes

import com.example.kmm.data.deserts
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*


fun Route.getById() {
    get("/getById") {
        val id: String = call.parameters["id"] ?: throw Throwable("No id send")
        deserts.find { it.id == id }?.let {
            call.respond(it)
        } ?: throw Throwable("No desert found with this id")
    }
}