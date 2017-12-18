package pl.kmo2008.demo.Model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Model class for Food
 */

@Entity
public class Food implements Serializable {
    /**
     * ID field
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    /**
     * Name field
     */
    private String name;
    /**
     * Price field
     */
    private double price;
    /**
     * Categories link field
     */
    @ManyToOne(optional = false)
    @JoinColumn
    private Categories category;
    /**
     * Lang field
     */
    private String lang;
    /**
     * Empty contructor
     */
    public Food() {
    }

    /**
     * ID getter
     * @return (int) ID of food
     */
    public int getId() {
        return id;
    }

    /**
     * ID setter
     * @param id(int) ID of food
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Name getter
     * @return (String) Name of food
     */
    public String getName() {
        return name;
    }

    /**
     * Name setter
     * @param name(String) Name of food
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Price getter
     * @return (double) Price of food
     */
    public double getPrice() {
        return price;
    }

    /**
     * Price setter
     * @param price(double) Price of food
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Categories getter
     * @return (Categories) Category of food
     */
    public Categories getCategory() {
        return category;
    }

    /**
     * Categories setter
     * @param category(Categories) Category of food
     */
    public void setCategory(Categories category) {
        this.category = category;
    }

    /**
     * Lang getter
     * @return (String) Lang of food
     */
    public String getLang() {
        return lang;
    }

    /**
     * Lang setter
     * @param lang(String) Lang of food
     */
    public void setLang(String lang) {
        this.lang = lang;
    }
}
