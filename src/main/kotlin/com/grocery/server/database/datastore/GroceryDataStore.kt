package com.grocery.server.database.datastore

import com.grocery.server.database.model.Grocery
import org.litote.kmongo.reactivestreams.getCollection

object GroceryDataStore : AbstractDataStore() {

    private val collection = database.getCollection<Grocery>()

    fun addGrocery(groceryListId: Int, grocery: Grocery) {

    }

    fun removeGrocery(groceryListId: Int, groceryId: Int) {

    }

}