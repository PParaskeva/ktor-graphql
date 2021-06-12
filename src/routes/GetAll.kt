package com.example.kmm.routes

import com.example.kmm.data.deserts
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.getAll() {
    get ("/getAll"){
        call.respond(deserts)
    }
}