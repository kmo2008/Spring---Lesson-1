package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Summary {

    @Autowired
    private Order order;

    @RequestMapping("/showOrder")
    public String showOrder() {
        return order.getItems().toString();
    }
}
