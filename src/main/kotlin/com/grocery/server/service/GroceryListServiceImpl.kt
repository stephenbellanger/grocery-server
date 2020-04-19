package com.grocery.server.service

import com.grocery.server.dao.GroceryListDao
import com.grocery.server.model.GroceryList
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

class GroceryListServiceImpl : GroceryListService {

    @Autowired
    lateinit var dao: GroceryListDao

    override fun createGroceryList(name: String) {
        val groceryList = GroceryList(
            name = name,
            groceries = listOf()
        )
        dao.save(groceryList)
    }

    override fun getGroceryList(id: Int): Optional<GroceryList> {
        return dao.findById(id)
    }

    override fun removeGroceryList(id: Int) {
        dao.deleteById(id)
    }

}