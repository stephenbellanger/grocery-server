package com.grocery.server.database.model

import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id
import org.litote.kmongo.newId

data class Grocery(
    @BsonId
    val key: Id<Grocery> = newId(),
    val name: String,
    val quantity: Int
)