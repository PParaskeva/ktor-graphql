package com.example.kmm.routes

import com.example.kmm.data.deserts
import com.example.kmm.models.Desert
import com.google.gson.Gson
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.update() {
    post("/update") {
        val desert: Desert = Gson().fromJson(call.receive<String>(), Desert::class.java)
        val index = deserts.indexOfFirst { it.id == desert.id }
        if (index != -1) {
            deserts[index].apply {
                name = desert.name ?: ""
                description = desert.description ?: ""
                imageUrl = desert.imageUrl ?: ""
            }
            call.respond("Desert updated")
        } else {
            call.respond("No desert with this id found")
        }
    }
}