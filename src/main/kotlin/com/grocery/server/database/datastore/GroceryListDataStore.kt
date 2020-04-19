package com.grocery.server.database.datastore

import com.grocery.server.database.model.GroceryList
import io.reactivex.Completable
import io.reactivex.Maybe
import org.litote.kmongo.*
import org.litote.kmongo.reactivestreams.getCollection
import org.litote.kmongo.rxjava2.deleteOneById
import org.litote.kmongo.rxjava2.findOne
import org.litote.kmongo.rxjava2.findOneById

object GroceryListDataStore : AbstractDataStore() {

    private val collection = database.getCollection<GroceryList>()

    fun createGroceryList(name: String): Maybe<GroceryList> {
        val groceryList = GroceryList(
            name = name,
            groceries = listOf()
        )
        collection.insertOne(groceryList)
        return collection.findOne(GroceryList::name eq name)
    }

    fun getGroceryList(id: Int): Maybe<GroceryList> {
        return collection.findOneById(id)
    }

    fun removeGroceryList(id: Int): Completable {
        return Completable.fromAction {
            collection.deleteOneById(id)
        }
    }
}