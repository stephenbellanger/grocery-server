package com.grocery.server.service

import com.grocery.server.dao.GroceryDao
import com.grocery.server.dao.GroceryListDao
import com.grocery.server.model.Grocery
import org.springframework.beans.factory.annotation.Autowired

class GroceryServiceImpl : GroceryService {

    @Autowired
    lateinit var groceryListDao: GroceryListDao

    @Autowired
    lateinit var groceryDao: GroceryDao

    override fun addGrocery(groceryListId: Int, grocery: Grocery) {
        groceryListDao.findById(groceryListId).ifPresent { groceryList ->
            groceryList.groceries.toMutableList().add(grocery)
            groceryListDao.save(groceryList)
        }
    }

    override fun removeGrocery(groceryListId: Int, groceryId: Int) {
        groceryListDao.findById(groceryListId).ifPresent { groceryList ->
            groceryDao.findById(groceryId).ifPresent { grocery ->
                groceryList.groceries.toMutableList().remove(grocery)
                groceryListDao.save(groceryList)
            }
        }
    }

}