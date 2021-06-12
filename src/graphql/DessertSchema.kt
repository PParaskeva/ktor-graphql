package com.example.kmm.graphql

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import com.example.kmm.models.Desert
import com.example.kmm.models.DesertInput
import com.example.kmm.repository.DessertRepository
import java.util.*

fun SchemaBuilder.desertSchema() {
    val repository = DessertRepository()

    inputType<DesertInput> {
        description = "The input of the desert without the identifier"
    }

    type<Desert> {
        description = "Desert object with attributes names, description and imageUrl"
    }

    query("desert") {
        resolver<Desert?, String> { desertId ->
            repository.getById(desertId)
        }
    }

    query("deserts") {
        resolver<List<Desert>> {
            repository.getAll()
        }
    }

    mutation("createDesert") {
        description = "Create a new desert"
        resolver { desertInput: DesertInput ->
            repository.add(
                Desert(
                    id = UUID.randomUUID().toString(),
                    name = desertInput.name,
                    description = desertInput.description,
                    imageUrl = desertInput.imageUrl
                )
            )
        }
    }

    mutation("updateDesert") {
        description = "Update a current desert"
        resolver<Desert, Desert> { desertInput ->
            repository.update(desertInput)
        }
    }

}