package com.grocery.server.database.model

import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id
import org.litote.kmongo.newId

data class GroceryList(
    @BsonId
    val key: Id<GroceryList> = newId(),
    val name: String,
    val groceries: List<Grocery>
)