package com.grocery.server.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("grocery_list")
class GroceryList(
    @Id
    val id: Int = -1,
    val name: String,
    val groceries: List<Grocery>
)