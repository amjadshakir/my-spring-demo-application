package com.techreturners.myspringdemo.controller;

import com.techreturners.myspringdemo.model.Coffee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CoffeeController {
    private final AtomicLong id = new AtomicLong();
@GetMapping("/coffeelover")
    public String coffeeLover(){
        return "I like coffee!";
    }
    @GetMapping("/coffee")
    public Coffee getCoffee(@RequestParam(value = "name",defaultValue = "latte") String name){
    return new Coffee(id.incrementAndGet(),name);
    }


}
