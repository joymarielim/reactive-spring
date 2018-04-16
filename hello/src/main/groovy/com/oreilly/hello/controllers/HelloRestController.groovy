package com.oreilly.hello.controllers

import com.oreilly.hello.entities.Greeting
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloRestController {

    @GetMapping("/rest")
    Greeting greet(@RequestParam(defaultValue = "World") String name){
        return new Greeting(message: "Hello, $name")
    }
}
