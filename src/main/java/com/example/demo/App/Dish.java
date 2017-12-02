package com.example.demo.App;

/**
 * Model class for Dishes
 */
public class Dish {
    /**
     * Dish ID
     */
    private int id;
    /**
     * Price of Dish
     */
    private double price;
    /**
     * Name of dish
     */
    private String name;
    /**
     * Is gluten meal?
     */
    private boolean glutenfree;
    /**
     * Is vegan meal?
     */
    private boolean vegan;
    /**
     * Does this dish contain meat?
     */
    private boolean meat;

    /**
     * Empty contructor of Dish for good work dish adding
     */
    public Dish() {
    }

    /**
     * Override tostring method
     * @return String with all parameters.
     */
    @Override
    public String toString() {
        return "Dish{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", glutenfree=" + glutenfree +
                ", vegan=" + vegan +
                ", meat=" + meat +
                '}';
    }

    /**
     * Constructor with all variables.
     * @param id(int) Id of Dish
     * @param name(String) Name of Dish
     * @param price(double) Price of dish
     * @param glutenfree(bool) Is glutenfree dish?
     * @param vegan(bool) Is vegan Dish?
     * @param meat(bool) Is meat Dish?
     */
    public Dish(int id, String name, double price, boolean glutenfree, boolean vegan, boolean meat) {
        this.price = price;
        this.name = name;
        this.id = id;
        this.glutenfree = glutenfree;
        this.vegan = vegan;
        this.meat = meat;
    }

    /**
     * Price setter
     * @param price(Double) New value of Dish price.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Name Getter
     * @return (String)Value of Dish name.
     */
    public String getName() {

        return name;
    }

    /**
     * Glutenfree setter
     * @param gluten(bool) New value of glutenfree state.
     */

    public void setGluten(boolean gluten) {
        this.glutenfree = gluten;
    }

    /**
     * Vegan Getter
     * @return Value of vegan state.
     */
    public boolean isVegan() {
        return vegan;
    }

    /**
     * Vegan setter
     * @param vegan(bool) New value of vegan state.
     */
    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    /**
     * Name setter
     * @param name(String) New name of Dish.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gluten getter
     * @return (bool) Value of gluten state.
     */
    public boolean isGlutenfree() {
        return glutenfree;
    }

    /**
     * Glutenfree setter
     * @param glutenfree(bool) New value of gluten state.
     */

    public void setGlutenfree(boolean glutenfree) {
        this.glutenfree = glutenfree;
    }

    /**
     * Meat getter
     * @return (bool) Value of meat state.
     */
    public boolean isMeat() {

        return meat;
    }

    /**
     * Meat setter
     * @param meat(bool) New value of meat state.
     */
    public void setMeat(boolean meat) {
        this.meat = meat;
    }

    /**
     * Id getter
     * @return (int) Value of ID state.
     */
    public int getId() {
        return id;
    }

    /**
     * Id setter
     * @param id(int) New value of ID state.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Price getter
     * @return (double) Value of price.
     */
    public double getPrice() {

        return price;
    }
}
