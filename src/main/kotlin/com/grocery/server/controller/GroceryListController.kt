package com.grocery.server.controller

import com.grocery.server.model.GroceryList
import com.grocery.server.service.GroceryListService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/grocery_list")
class GroceryListController {

    @Autowired
    @Qualifier(value = "groceryListService")
    private lateinit var service: GroceryListService

    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    fun createGroceryList(@PathVariable(value = "name") name: String) {
        println("-------> : createGroceryList")
        logger.debug("Create grocery list.")
        service.createGroceryList(name)
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getGroceryList(@PathVariable(value = "id") id: Int): Optional<GroceryList> {
        println("-------> : getGroceryList")
        logger.debug("Get grocery list.")
        return service.getGroceryList(id)
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun removeGroceryList(@PathVariable(value = "id") id: Int) {
        println("-------> : removeGroceryList")
        logger.debug("Remove grocery list.")
        service.removeGroceryList(id)
    }
}