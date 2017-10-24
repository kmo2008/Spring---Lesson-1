package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

@Service
public class Order {

    private ArrayList<Pizza> items;

    public Order() {

        items = new ArrayList<>();

    }

    public String showPizza(int id)
    {
        String name;
        String show = "xxx";
        float prize;
        Iterator<Pizza> pizzaIterator = items.iterator();
        while (pizzaIterator.hasNext()) {
            if (pizzaIterator.next().getId() == id) {
                name = pizzaIterator.next().getName() ;
                prize = pizzaIterator.next().getPrice();
               show = "("+id+")Pizza " + name + ". Cena: " + Float.toString(prize);
            }
        }
        return show;
    }

    public String addPizza(int id, String name, float prize) {
        String info = "xxx";
        Pizza newPizza = new Pizza(prize, name, id);
        items.add(newPizza);
        info = "Dodano: ("+id+")Pizza " + name + ". Cena: " + prize;
        return info;
    }

    public String modifyPizza(int id, String name, float prize) {
        String info = "xxx";
        Iterator<Pizza> pizzaIterator = items.iterator();
        while (pizzaIterator.hasNext()) {
            if (pizzaIterator.next().getId() == id) {
                pizzaIterator.next().setName(name);
                pizzaIterator.next().setPrice(prize);
            }
        }
        info = "Edytowano: ("+id+")Pizza " + name + ". Cena: " + prize;
        return info;
    }

    public String delPizza(int id) {
        String info = "xxx";
        Iterator<Pizza> pizzaIterator = items.iterator();
        while (pizzaIterator.hasNext()) {
            if (pizzaIterator.next().getId() == id) {
                items.remove(pizzaIterator.next());
            }
        }
        info = "Usunieto: ("+id+")";
        return info;
    }

    public ArrayList<Pizza> getItems() {
        return items;
    }

    public void setItems(ArrayList<Pizza> items) {
        this.items = items;
    }


}
