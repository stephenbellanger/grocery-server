package com.grocery.server.controller

import com.grocery.server.model.Grocery
import com.grocery.server.service.GroceryService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/grocery")
class GroceryController {

    @Autowired
    @Qualifier(value = "groceryService")
    private lateinit var service: GroceryService

    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @GetMapping("/{grocery-list-id}")
    @ResponseStatus(HttpStatus.OK)
    fun addGrocery(@PathVariable(value = "grocery-list-id") groceryListId: Int, grocery: Grocery) {
        println("-------> : addGrocery")
        logger.debug("Add grocery in list.")
        service.addGrocery(groceryListId, grocery)
    }

    @GetMapping("/{grocery-list-id}/grocery/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun removeGrocery(
        @PathVariable(value = "grocery-list-id") groceryListId: Int,
        @PathVariable(value = "id") groceryId: Int
    ) {
        println("-------> : removeGrocery")
        logger.debug("Remove grocery in list.")
        service.removeGrocery(groceryListId, groceryId)
    }

}