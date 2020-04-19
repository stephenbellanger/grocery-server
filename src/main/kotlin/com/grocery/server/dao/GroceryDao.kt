package com.grocery.server.dao

import com.grocery.server.model.Grocery
import org.springframework.data.mongodb.repository.MongoRepository

interface GroceryDao : MongoRepository<Grocery, Int> {

}