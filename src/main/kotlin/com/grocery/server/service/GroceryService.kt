package com.grocery.server.service

import com.grocery.server.model.Grocery

interface GroceryService {
    fun addGrocery(groceryListId: Int, grocery: Grocery)
    fun removeGrocery(groceryListId: Int, groceryId: Int)
}