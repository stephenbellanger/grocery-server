package com.grocery.server.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("grocery")
class Grocery(
    @Id
    val id: Int,
    val name: String,
    val quantity: Int
)