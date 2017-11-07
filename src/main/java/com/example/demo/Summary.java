package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Summary {

    @Autowired
    private Order order;

    @RequestMapping(value = "/showPizza", method = RequestMethod.POST)
    public String showPizza(@RequestParam int id) {
        return order.showPizza(id);
    }

    @RequestMapping(value = "/addPizza", method = RequestMethod.POST)
    public String addPizza(@RequestParam int id,@RequestParam  String name,@RequestParam  float prize) {
        return order.addPizza(id, name, prize);
    }

    @RequestMapping(value = "/modifyPizza", method = RequestMethod.POST)
    public String modifyPizza(@RequestParam int id,@RequestParam  String name,@RequestParam  float prize) {
        return order.modifyPizza(id, name, prize);
    }

    @RequestMapping(value = "/delPizza", method = RequestMethod.POST)
    public String delPizza(@RequestParam int id) {
        return order.delPizza(id);
    }

}
