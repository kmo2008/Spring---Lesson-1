package com.example.demo.Gui;

import com.example.demo.App.Dish;
import com.example.demo.App.Menu;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.server.*;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * GUI class of Menu.
 */
@SpringUI(path = "/guishowDisches")
public class Show extends UI {

    /**
     * Wired menu class.
     */
    @Autowired
    private Menu menu;
    /**
     * RadioButton
     */
    private RadioButtonGroup dishoption;

    /**
     * Initial Method
     *
     */
    @Override
    protected void init(VaadinRequest request) {
        List<String> data = Arrays.asList("Mięsne", "Wegetariańskie", "Bez mięsne");
        dishoption = new RadioButtonGroup("Rodzaj dania:", data);
        ArrayList<Dish> dishes = new ArrayList<Dish>();
        dishes = menu.getDishesPL();
        Grid<Dish> grid = new Grid<Dish>(Dish.class);
        VerticalLayout ver = new VerticalLayout();
        HorizontalLayout hor = new HorizontalLayout();
        grid.setItems(dishes);
        grid.setWidth("100%");
        hor.addComponent(dishoption);
        ver.addComponent(grid);
        ver.addComponent(hor);
        setContent(ver);
    }
}
