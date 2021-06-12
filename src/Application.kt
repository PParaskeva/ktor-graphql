package com.example.kmm

import com.apurebase.kgraphql.GraphQL
import com.example.kmm.graphql.desertSchema
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(GraphQL) {
        playground = true
        schema {
            desertSchema()
        }
    }
}

