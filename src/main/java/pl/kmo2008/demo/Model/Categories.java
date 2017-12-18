package pl.kmo2008.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Model class for Categories
 */
@Entity
public class Categories implements Serializable {

    /**
     * ID field
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    /**
     * Vegan field.
     */
    private boolean vegan;
    /**
     * Meat field
     */
    private boolean meat;
    /**
     * Glutenfree field
     */
    private boolean glutenfree;

    /**
     * Empty constructor
     */
    public Categories() {
    }

    /**
     * ID getter
     *
     * @return (int) ID of category
     */
    public int getId() {
        return id;
    }

    /**
     * ID setter
     *
     * @param id(int) ID of category
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "vegan=" + vegan +
                ", meat=" + meat +
                ", glutenfree=" + glutenfree;
    }

    /**
     * Vegan getter
     *
     * @return (boolean) Value of vegan field
     */
    public boolean isVegan() {
        return vegan;
    }

    /**
     * Vegan setter
     *
     * @param vegan(boolean) Is vegan?
     */
    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    /**
     * Meat getter
     *
     * @return (boolean) Value of Meat field
     */
    public boolean isMeat() {
        return meat;
    }

    /**
     * Meat setter
     *
     * @param meat(boolean) Is Meat?
     */
    public void setMeat(boolean meat) {
        this.meat = meat;
    }

    /**
     * Glutenfree getter
     *
     * @return (boolean) Value of glutenfree field
     */
    public boolean isGlutenfree() {
        return glutenfree;
    }

    /**
     * Glutenfree setter
     *
     * @param glutenfree(boolean) Is gluten free?
     */
    public void setGlutenfree(boolean glutenfree) {
        this.glutenfree = glutenfree;
    }
}
