package com.example.kmm.routes

import com.example.kmm.data.deserts
import com.example.kmm.models.Desert
import com.google.gson.Gson
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.add() {
    post("/add") {
        val desert: Desert = Gson().fromJson(call.receive<String>(), Desert::class.java)
        deserts.find { it.id == desert.id }?.let {
            call.respond("A desert with the same id exist")
        } ?: run {
            deserts.add(desert)
            call.respond("Added the new desert")
        }
    }
}