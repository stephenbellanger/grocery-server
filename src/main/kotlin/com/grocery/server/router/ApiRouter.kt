package com.grocery.server.router

import com.grocery.server.database.datastore.GroceryDataStore
import com.grocery.server.database.datastore.GroceryListDataStore
import com.grocery.server.database.model.Grocery
import io.javalin.Javalin

fun main(args: Array<String>) {

    val port = System.getenv("PORT")?.toInt() ?: 23567

    val app = Javalin.create().apply {
        exception(Exception::class.java) { e, _ -> e.printStackTrace() }
        error(404) { ctx -> ctx.json("not found") }
    }.start(port)

    app.get("/grocery-list/:grocery-list-id") { ctx ->
        val groceryListId = ctx.pathParam("grocery-list-id").toInt()
        GroceryListDataStore.getGroceryList(groceryListId)
            .doOnSuccess {
                ctx.json(it)
            }
            .doOnError {
                ctx.status(201)
            }
    }

    app.post("/grocery-list/:grocery-list-name") { ctx ->
        val groceryListName = ctx.pathParam("grocery-list-name")
        GroceryListDataStore.createGroceryList(groceryListName)
            .doOnSuccess {
                ctx.json(it)
            }
            .doOnError {
                ctx.status(201)
            }
    }

    app.delete("/grocery-list/:grocery-list-id") { ctx ->
        val groceryListId = ctx.pathParam("grocery-list-id").toInt()
        GroceryListDataStore.removeGroceryList(groceryListId)
    }

    app.post("/:grocery-list-id/grocery") { ctx ->
        val groceryListId = ctx.pathParam("grocery-list-id").toInt()
        val grocery = ctx.bodyAsClass(Grocery::class.java)
        GroceryDataStore.addGrocery(groceryListId, grocery)
    }

    app.delete("/:grocery-list-id/grocery/:grocery-id") { ctx ->
        val groceryListId = ctx.pathParam("grocery-list-id").toInt()
        val groceryId = ctx.pathParam("grocery-id").toInt()
        GroceryDataStore.removeGrocery(groceryListId, groceryId)
    }
}