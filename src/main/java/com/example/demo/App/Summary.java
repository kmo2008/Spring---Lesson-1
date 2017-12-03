package com.example.demo.App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author Kmo2008
 * @version 1.0
 * @since 0.1
 * This class is Controll class of REST methods.
 */
@RestController
public class Summary {

    /**
     * This variable wired to menu.
     */
    @Autowired
    private Menu menu;

    /**
     * @param id(int) Id of Dish.
     * @return (String) String with Dish.
     */
    @RequestMapping(value = "/showDish", method = RequestMethod.POST)
    public String showDish(@RequestParam int id) {
        return menu.showDish(id);
    }

    /**
     * @param lang(String) String of PL or EN, other = merge.
     * @return String with List of Dishes.
     */
    @RequestMapping(value = "/showDishes", method = RequestMethod.POST)
    public String showDishes(@RequestHeader String lang) {
        if (lang.equals("EN")) return menu.showDishes(0);
        else if (lang.equals("PL")) return menu.showDishes(1);
        else return menu.showDishes(2);

    }

    /**
     * @param lang(String) String of PL or EN, other = merge.
     * @param dishes(JSON) List of Dishes.
     * @return (String) String of confirmed add.
     */
    @RequestMapping(value = "/addDishToList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addDish(@RequestHeader String lang, @RequestBody Dish dishes) {
        if (lang.equals("EN"))
            menu.dishAddEN(dishes);
        else if (lang.equals("PL"))
            menu.dishAddPL(dishes);
        else
            menu.dishAddAll(dishes);
        return "Dodano Danie";
    }

    /**
     * @param number(int) Number of showing dishes.
     * @param lang(String) String of PL or EN, other = merge.
     * @param vegan(int) Is Vegan? (0 or 1).
     * @param gluten(int) Has gluten? (0 or 1).
     * @param meat(int) is meat? (0 or 1).
     * @return (ArrayList) List of dishes.
     */
    @RequestMapping(value = "/showDishesList/{number}", method = RequestMethod.GET)
    public ArrayList<Dish> showDishesList(@PathVariable("number") Long number, @RequestParam String lang, @RequestParam int vegan, @RequestParam int gluten, @RequestParam int meat) {
        if (lang.equals("EN")) return menu.showDishesList(0, vegan, gluten, meat, number);
        else if (lang.equals("PL")) return menu.showDishesList(1, vegan, gluten, meat, number);
        else return menu.showDishesList(2, vegan, gluten, meat, number);
    }

    /**
     * @param id(int) ID of Dish.
     * @param name(String) Name of dish.
     * @param price(Double) Price of dish.
     * @return (String) String of added Dish
     */
    @RequestMapping(value = "/addDish", method = RequestMethod.POST)
    public String addDish(@RequestParam int id, @RequestParam String name, @RequestParam float price) {
        return menu.addDish(id, name, price);
    }

    /**
     * @param id(int) ID of Dish.
     * @param name(String) Name of dish.
     * @param price(Double) Price of dish.
     * @return (String) String of modify Dis
     */

    @RequestMapping(value = "/modifyDish", method = RequestMethod.PUT)
    public String modifyDish(@RequestParam int id, @RequestParam String name, @RequestParam float price) {
        return menu.modifyDish(id, name, price);
    }

    /**
     * @param id(int) ID of dish
     * @return (String) String of deleted Dish
     */
    @RequestMapping(value = "/delDish", method = RequestMethod.DELETE)
    public String delDish(@RequestParam int id) {
        return menu.delDish(id);
    }


}
