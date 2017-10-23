package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class Order {

    private Set<Pizza> items;

    public Order() {

        items = new HashSet<>();
        Pizza capriciosa = new Pizza(19.9f, "Capriciossa", 0);
        Pizza hawai = new Pizza(19.9f, "Hawaii", 1);
        Pizza chicken = new Pizza(18.5f, "Chicken", 2);
        items.add(capriciosa);
        items.add(hawai);
        items.add(chicken);
    }

    public Set<Pizza> getItems() {
        return items;
    }

    public void setItems(Set<Pizza> items) {
        this.items = items;
    }


}
