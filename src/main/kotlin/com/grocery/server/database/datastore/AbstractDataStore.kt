package com.grocery.server.database.datastore

import org.litote.kmongo.reactivestreams.KMongo

abstract class AbstractDataStore {

    companion object {
        private const val DATABASE_NAME = "GROCERY_DATABASE"

    }

    private val client = KMongo.createClient()
    protected val database = client.getDatabase(DATABASE_NAME)
}