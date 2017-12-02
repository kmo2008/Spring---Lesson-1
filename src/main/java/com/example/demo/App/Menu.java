package com.example.demo.App;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Model of Menu class.
 */
@Service
public class Menu {
    /**
     * List of Dishes in Polish.
     */
    private ArrayList<Dish> dishesPL;
    /**
     * List of Dishes in English.
     */
    private ArrayList<Dish> dishesEN;
    /**
     * Merge of both list (PL, EN)
     */
    private ArrayList<Dish> dishesAll;

    /**
     * Empty constructor with starting data of Dishes
     */
    public Menu() {
        dishesPL = new ArrayList<>();
        dishesPL.add(new Dish(0, "Schabowy", 13.9, false, false, true));
        dishesPL.add(new Dish(1, "Piers z kurczaka", 10, false, false, true));
        dishesPL.add(new Dish(2, "Nuggetsy z kurczaka", 9, false, false, true));
        dishesPL.add(new Dish(3, "Spaghetti bolonese bez mięsa", 12, false, true, false));
        dishesPL.add(new Dish(4, "Spaghetti bolonese z miesem", 13, false, false, true));
        dishesPL.add(new Dish(5, "Spaghett bolonese z miesen bez glutenu", 15, true, false, true));
        dishesPL.add(new Dish(6, "Rosol", 6, false, false, true));
        dishesPL.add(new Dish(7, "Zurek", 5, false, false, true));

        dishesEN = new ArrayList<>();
        dishesEN.add(new Dish(0, "Porkchop", 14.9, false, false, true));
        dishesEN.add(new Dish(1, "Chicken", 11, false, false, true));
        dishesEN.add(new Dish(2, "Chicken Nuggets", 10, false, false, true));
        dishesEN.add(new Dish(3, "Spaghetti bolonese without meat", 13, false, true, false));
        dishesEN.add(new Dish(4, "Spaghetti bolonese with meat", 14, false, false, true));
        dishesEN.add(new Dish(5, "Spaghett bolonese with meat gluten free", 16, true, false, true));
        dishesEN.add(new Dish(6, "Chciken soup", 7, false, false, true));
        dishesEN.add(new Dish(7, "Sour soup", 6, false, false, true));

        dishesAll = new ArrayList<>();
        dishesAll.addAll(dishesPL);
        dishesAll.addAll(dishesEN);
    }

    /**
     * Adding new Dish to English list.
     * @param dish(Dish) Dish object.
     */
    public void dishAddEN(Dish dish) {
        dishesEN.add(dish);
    }

    /**
     * Adding new Dish to Polish list.
     * @param dish(Dish) Dish object.
     */
    public void dishAddPL(Dish dish) {
        dishesPL.add(dish);
    }

    /**
     * Adding new list to merge list
     * @param dish(Dish) Dish object.
     */
    public void dishAddAll(Dish dish) {
        dishesAll.add(dish);
    }

    /**
     * Shows the selected number of dishes.
     * @param lang(int) Language of lsit (0 - English, 1 - Polish, other - Merge list)
     * @param vegan(bool) State of vegan Dish.
     * @param gluten(bool) State of glutenfree Dish.
     * @param meat(booL0 State of meat Dish.
     * @param number(int) Number of Dishes to show.
     * @return (ArrayList) List of Dishes.
     */
    public ArrayList<Dish> showDishesList(int lang, int vegan, int gluten, int meat, long number) {
        ArrayList<Dish> dishesENedit = new ArrayList<>(dishesEN);
        ArrayList<Dish> dishesPLedit = new ArrayList<>(dishesPL);
        ArrayList<Dish> dishesAlledit = new ArrayList<>(dishesAll);
        ArrayList<Dish> returnList = new ArrayList<>();
        returnList.clear();
        Iterator<Dish> pizzaIterator = null;
            if (vegan == 1 && gluten == 0 && meat == 0) {
                Dish dish = null;
                if (lang == 0) {
                    pizzaIterator = dishesENedit.iterator();
                } else if (lang == 1) {
                    pizzaIterator = dishesPLedit.iterator();
                } else pizzaIterator = dishesAlledit.iterator();
                while (pizzaIterator.hasNext()) {
                    dish = pizzaIterator.next();
                    if (dish.isVegan()) returnList.add(dish);
                }
            } else if (vegan == 0 && gluten == 1 && meat == 0) {
                Dish dish = null;
                if (lang == 0) {
                    pizzaIterator = dishesENedit.iterator();
                } else if (lang == 1) {
                    pizzaIterator = dishesPLedit.iterator();
                } else pizzaIterator = dishesAlledit.iterator();
                while (pizzaIterator.hasNext()) {
                    dish = pizzaIterator.next();
                    if (dish.isGlutenfree()) returnList.add(dish);
                }
            } else if (vegan == 0 && gluten == 0 && meat == 1) {
                Dish dish = null;
                if (lang == 0) {
                    pizzaIterator = dishesENedit.iterator();
                } else if (lang == 1) {
                    pizzaIterator = dishesPLedit.iterator();
                } else pizzaIterator = dishesAlledit.iterator();
                while (pizzaIterator.hasNext()) {
                    dish = pizzaIterator.next();
                    if (dish.isMeat()) returnList.add(dish);
                }
            } else if (vegan == 1 && gluten == 1) {
                Dish dish = null;
                if (lang == 0) {
                    pizzaIterator = dishesENedit.iterator();
                } else if (lang == 1) {
                    pizzaIterator = dishesPLedit.iterator();
                } else pizzaIterator = dishesAlledit.iterator();
                while (pizzaIterator.hasNext()) {
                    dish = pizzaIterator.next();
                    if (dish.isVegan() && dish.isGlutenfree()) returnList.add(dish);
                }
            } else if (meat == 1 && gluten == 1) {
                Dish dish = null;
                if (lang == 0) {
                    pizzaIterator = dishesENedit.iterator();
                } else if (lang == 1) {
                    pizzaIterator = dishesPLedit.iterator();
                } else pizzaIterator = dishesAlledit.iterator();
                while (pizzaIterator.hasNext()) {
                    dish = pizzaIterator.next();
                    if (dish.isMeat() && dish.isGlutenfree()) returnList.add(dish);
                }
            } else if (meat == 0) {
                Dish dish = null;
                if (lang == 0) {
                    pizzaIterator = dishesENedit.iterator();
                } else if (lang == 1) {
                    pizzaIterator = dishesPLedit.iterator();
                } else pizzaIterator = dishesAlledit.iterator();
                while (pizzaIterator.hasNext()) {
                    dish = pizzaIterator.next();
                    if (!dish.isMeat()) returnList.add(dish);
                }
            } else {
            if (lang == 0) {
                returnList = dishesENedit;
            } else if (lang == 1) {
                returnList = dishesPLedit;
            } else {
                returnList = dishesAlledit;
            }
        }
        if (number > 0) {
            if (number > returnList.size() && number < returnList.size())
                returnList = showDishesList(lang, vegan, gluten, meat, number);
            while (returnList.size() > number) {
                returnList.remove(returnList.size() - 1);
            }
        }
        return returnList;
    }

    /**
     * Shows all dishes in selected language in String
     * @param lang(int) Language of lsit (0 - English, 1 - Polish, other - Merge list)
     * @return (String) String of dishes.
     */
    public String showDishes(int lang) {
        String name;
        int id;
        String show = "MENU";
        double prize;
        if (lang == 0) {
            Iterator<Dish> pizzaIterator = dishesEN.iterator();
            while (pizzaIterator.hasNext()) {
                Dish dish = pizzaIterator.next();
                name = dish.getName();
                prize = dish.getPrice();
                show += "<br />Dish: " + name + " Cena: " + Double.toString(prize);


            }
        } else if (lang == 1) {
            Iterator<Dish> pizzaIterator = dishesPL.iterator();
            while (pizzaIterator.hasNext()) {
                Dish dish = pizzaIterator.next();
                name = dish.getName();
                prize = dish.getPrice();
                show += "<br />Dish: " + name + ". Cena: " + Double.toString(prize);
            }
        } else {
            Iterator<Dish> pizzaIterator = dishesPL.iterator();
            while (pizzaIterator.hasNext()) {
                Dish dish = pizzaIterator.next();
                name = dish.getName();
                prize = dish.getPrice();
                show += "<br />Dish: " + name + ". Cena: " + Double.toString(prize);
            }
            pizzaIterator = dishesEN.iterator();
            while (pizzaIterator.hasNext()) {
                Dish dish = pizzaIterator.next();
                name = dish.getName();
                prize = dish.getPrice();
                show += "<br />Dish: " + name + ". Cena: " + Double.toString(prize);
            }
        }
        return show;
    }

    /**
     * Show one Dish.
     * @param id(int) Id of Dish.
     * @return (String) String of Dish. (id, name, price)
     */

    public String showDish(int id) {
        String name;
        String show = "xxx";
        double price;
        Iterator<Dish> pizzaIterator = dishesPL.iterator();
        while (pizzaIterator.hasNext()) {
            if (pizzaIterator.next().getId() == id) {
                name = pizzaIterator.next().getName();
                price = pizzaIterator.next().getPrice();
                show = "(" + id + ")Dish " + name + ". Cena: " + Double.toString(price);
            }
        }
        return show;
    }

    /**
     * Method to add Dish only with id, name, price.
     * @param id(int) - ID of Dish.
     * @param name(String) - Name of Dish.
     * @param price(double) - Price of Dish.
     * @return (String) String of added Dish.
     */
    public String addDish(int id, String name, double price) {
        String info = "xxx";
        Dish newDish = new Dish(id, name, price, false, false, false);
        dishesPL.add(newDish);
        info = "Dodano: (" + id + ")Dish " + name + ". Cena: " + price;
        return info;
    }

    /**
     * Method for modify Dish.
     * @param id(int) - ID of Dish.
     * @param name(String) - Name of Dish.
     * @param price(double) - Price of Dish.
     * @return (String) String of modyfied Dish.
     */
    public String modifyDish(int id, String name, double price) {
        String info = "xxx";
        Iterator<Dish> pizzaIterator = dishesPL.iterator();
        while (pizzaIterator.hasNext()) {
            if (pizzaIterator.next().getId() == id) {
                pizzaIterator.next().setName(name);
                pizzaIterator.next().setPrice(price);
            }
        }
        info = "Edytowano: (" + id + ")Dish " + name + ". Cena: " + price;
        return info;
    }

    /**
     * Method for deleted Dish.
     * @param id(int) ID of Dish.
     * @return (String) String obout id of deleting Dish.
     */
    public String delDish(int id) {
        String info = "xxx";
        Iterator<Dish> pizzaIterator = dishesPL.iterator();
        while (pizzaIterator.hasNext()) {
            if (pizzaIterator.next().getId() == id) {
                dishesPL.remove(pizzaIterator.next());
            }
        }
        info = "Usunieto: (" + id + ")";
        return info;
    }

    /**
     * Getter of Polish Dishes list.
     * @return (ArrayList) List of Dishes.
     */
    public ArrayList<Dish> getDishesPL() {
        return dishesPL;
    }

    /**
     * Setter of Polsih Dishes list.
     * @param dishesPL(ArrayList) New list of Dishes.
     */
    public void setDishesPL(ArrayList<Dish> dishesPL) {
        this.dishesPL = dishesPL;
    }

    /**
     * Getter of English Dish list.
     * @return (ArrayList) List of Dishes
     */
    public ArrayList<Dish> getDishesEN() {
        return dishesEN;
    }

    /**
     * Setter of English Dishes list.
     * @param dishesEN(ArrayList) New list of Dishes.
     */
    public void setDishesEN(ArrayList<Dish> dishesEN) {
        this.dishesEN = dishesEN;
    }

    /**
     * Getter of Merge Dish list.
     * @return (ArrayList) List of Dishes
     */
    public ArrayList<Dish> getDishesAll() {
        return dishesAll;
    }

    /**
     * Setter of Merge Dishes list.
     * @param dishesAll(ArrayList) New list of Dishes.
     */
    public void setDishesAll(ArrayList<Dish> dishesAll) {
        this.dishesAll = dishesAll;
    }
}
