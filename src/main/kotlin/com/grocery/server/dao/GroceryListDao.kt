package com.grocery.server.dao

import com.grocery.server.model.GroceryList
import org.springframework.data.mongodb.repository.MongoRepository

interface GroceryListDao : MongoRepository<GroceryList, Int> {

}