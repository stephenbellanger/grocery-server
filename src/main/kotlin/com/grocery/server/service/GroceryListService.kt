package com.grocery.server.service

import com.grocery.server.model.GroceryList
import java.util.*

interface GroceryListService {
    fun createGroceryList(name: String)
    fun getGroceryList(id: Int): Optional<GroceryList>
    fun removeGroceryList(id: Int)
}