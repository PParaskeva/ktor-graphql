package com.example.kmm.repository

import com.example.kmm.data.deserts
import com.example.kmm.models.Desert

class DessertRepository : RepositoryInterface<Desert> {

    override fun getById(id: String): Desert = deserts.find { it.id == id } ?: throw Throwable("No value found")

    override fun getAll(): List<Desert> = deserts

    override fun delete(id: String): Boolean = deserts.find { it.id == id }?.let { desert ->
        deserts.remove(desert)
    } ?: throw Throwable("No value found")

    override fun add(entry: Desert): Desert {
        if (!deserts.contains(entry)) {
            deserts.add(entry)
        } else {
            throw Throwable("Entry already exist")
        }
        return entry
    }

    override fun update(entry: Desert): Desert = deserts.find { it.id == entry.id }?.apply {
        name = entry.name
        description = entry.description
        imageUrl = entry.imageUrl
    } ?: throw Throwable("No value found")
}