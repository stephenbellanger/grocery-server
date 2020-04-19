package com.grocery.server.config

import com.grocery.server.service.GroceryListService
import com.grocery.server.service.GroceryListServiceImpl
import com.grocery.server.service.GroceryService
import com.grocery.server.service.GroceryServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan("com.grocery.server")
open class ApplicationConfig {

    @Bean(name = ["groceryListService"])
    open fun getGroceryListService(): GroceryListService? {
        return GroceryListServiceImpl()
    }

    @Bean(name = ["groceryService"])
    open fun getGroceryService(): GroceryService? {
        return GroceryServiceImpl()
    }
}