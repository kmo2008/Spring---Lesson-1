package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Summary {

    @Autowired
    private Order order;

    @RequestMapping("/showPizza")
    public String showPizza(@RequestParam int id) {
        return order.showPizza(id);
    }

    @RequestMapping("/addPizza")
    public String addPizza(@RequestParam int id,@RequestParam String name,@RequestParam float prize) {
        return order.addPizza(id, name, prize);
    }

    @RequestMapping("/modifyPizza")
    public String modifyPizza(@RequestParam int id,@RequestParam String name,@RequestParam float prize) {
        return order.modifyPizza(id, name, prize);
    }

    @RequestMapping("/delPizza")
    public String delPizza(@RequestParam int id) {
        return order.delPizza(id);
    }

}
