package com.example.kmm.routes

import com.example.kmm.data.deserts
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.delete() {
    delete("/delete") {
        val id = call.parameters["id"] ?: throw Throwable("No id send")
        val result = deserts.removeIf { it.id == id }

        if (result) {
            call.respond("Desert delete")
        } else {
            call.respond("No desert with this id")
        }
    }
}