package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

        @RequestMapping("/aaa")
        public String main(){
            return "Hello World!!!";
        }
}
