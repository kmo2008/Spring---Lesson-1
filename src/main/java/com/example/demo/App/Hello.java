package com.example.demo.App;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * First clas for learg Spring - How to work?
 */
@RestController
public class Hello {
    /**
     * Watching How wark @Requestmapping
     * @return (String) Hello World!!!
     */
    @RequestMapping("/aaa")
    public String main() {
        return "Hello World!!!";
    }
}
