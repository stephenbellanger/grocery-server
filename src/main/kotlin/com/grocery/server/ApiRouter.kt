package com.grocery.server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * https://github.com/tonux/crud-springboot-mongoDB
 * https://medium.com/@ndongotonuxsamb/crud-avec-spring-boot-et-mongodb-6a13f24f6680
 */
@SpringBootApplication
open class ApiRouter {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(ApiRouter::class.java, *args)
        }
    }
}