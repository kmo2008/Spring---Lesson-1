package com.example.demo.Gui;

import com.example.demo.App.Dish;
import com.example.demo.App.Menu;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.server.*;
import com.vaadin.ui.*;
import com.vaadin.ui.Label;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.soap.Text;
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
     * Initial Method
     */
    @Override
    protected void init(VaadinRequest request) {


        /**
         * Lists declarations
         */
        List<String> data = Arrays.asList("Mięsne", "Wegetariańskie", "Bez mięsne");
        List<String> lang = Arrays.asList("PL", "EN", "All");
        ArrayList<Dish> dishes = menu.getDishesPL();


        /**
         * Layouts
         */
        VerticalLayout ver = new VerticalLayout();
        VerticalLayout ver1 = new VerticalLayout();
        VerticalLayout ver2 = new VerticalLayout();
        VerticalLayout ver3 = new VerticalLayout();

        VerticalLayout windowver = new VerticalLayout();
        VerticalLayout windowver1 = new VerticalLayout();

        HorizontalLayout hor = new HorizontalLayout();
        HorizontalLayout windowhor = new HorizontalLayout();


        /**
         * UI object create.
         */
        final Window window = new Window("Nowe danie");
        RadioButtonGroup dishoption = new RadioButtonGroup("Rodzaj dania:", data);
        Grid<Dish> grid = new Grid<>(Dish.class);
        Button refreshbutton = new Button("Odśwież");
        Button addnew = new Button("Dodaj nowe danie");
        CheckBox glutenfree = new CheckBox("Glutenfree");
        Slider slider = new Slider();
        Label slidercount = new Label();
        ComboBox combo = new ComboBox<>("Wybierz język", lang);

        /**
         * Widnwos UI objects
         */
        TextField idfield = new TextField("Id: ");
        TextField namefield = new TextField("Nazwa: ");
        TextField pricefield = new TextField("Cena: ");
        RadioButtonGroup windowdishoption = new RadioButtonGroup("Rodzaj dania:", data);
        CheckBox glutenbox = new CheckBox("Bez glutenu");
        ComboBox windowcombobox = new ComboBox<>("Wybierz język", lang);
        Button savebutton = new Button("Dodaj");

        /**
         * Object settings
         */
        window.setWidth(300.0f, Unit.PIXELS);

        windowdishoption.setSelectedItem(data.get(0));

        dishoption.setSelectedItem(data.get(0));

        slider.setMin(0.0);
        slider.setMax(100.0);
        slider.setValue(1.0);
        slidercount.setValue("Ilość wyświetlanych produktów:  1");


        grid.setItems(dishes);
        grid.setWidth("100%");
        grid.setColumnOrder("id", "name", "price", "vegan", "glutenfree", "meat");
        /**
         * Listeners
         */
        slider.addValueChangeListener(event -> {
            slidercount.setValue("Ilość wyświetlanych produktów: " + slider.getValue().intValue());
        });

        refreshbutton.addClickListener(clickEvent -> {

            int meat = 0;
            int vegan = 0;
            int gluten = 0;
            int number = 0;
            int language = 0;


            if (dishoption.isSelected("Mięsne")) meat = 1;
            else if (dishoption.isSelected("Wegetariańskie")) vegan = 0;
            if (glutenfree.getValue()) gluten = 1;
            number = slider.getValue().intValue();
            if (combo.isSelected("PL")) language = 1;
            else if (combo.isSelected("EN")) language = 0;
            else language = 3;
            System.out.println(meat + " " + vegan + " " + gluten + " " + number + " " + language);
            grid.setItems(menu.showDishesList(language, vegan, gluten, meat, number));
        });

        addnew.addClickListener(clickEvent -> {
            addWindow(window);
        });


        /**
         * Subwindows action listener
         */
        savebutton.addClickListener(clickEvent -> {
            int idnew = Integer.parseInt(idfield.getValue());
            String namenew = namefield.getValue();
            double pricenew = Double.parseDouble(pricefield.getValue());
            boolean  meatnew = false;
            boolean  vegannew = false;
            boolean glutennew = false;
            int langnew = 0;
            if (windowdishoption.isSelected("Mięsne")) meatnew = true;
            else if(windowdishoption.isSelected("Wegetariańskie"))vegannew = true;
            if(glutenbox.getValue())glutennew = true;
            if(windowcombobox.isSelected("PL")) menu.dishAddPL(new Dish(idnew, namenew, pricenew,glutennew,vegannew,meatnew));
            else if(windowcombobox.isSelected("EN")) menu.dishAddEN(new Dish(idnew, namenew, pricenew,glutennew,vegannew,meatnew));
            else menu.dishAddAll(new Dish(idnew, namenew, pricenew,glutennew,vegannew,meatnew));
            Notification.show("Dodano nowe danie.", Notification.Type.TRAY_NOTIFICATION);
            window.close();

            idfield.clear();
            namefield.clear();
            pricefield.clear();
            glutenbox.clear();
            windowcombobox.clear();

        });

        /**
         * General layout settings
         */
        ver1.addComponent(dishoption);
        ver1.addComponent(glutenfree);
        hor.addComponent(ver1);
        ver2.addComponent(combo);
        ver2.addComponent(slidercount);
        ver2.addComponent(slider);
        hor.addComponent(ver2);
        ver3.addComponent(refreshbutton);
        ver3.addComponent(addnew);
        hor.addComponent(ver3);

        ver.addComponent(grid);
        ver.addComponent(hor);
        setContent(ver);


        /**
         * Window layout
         */

        final FormLayout content = new FormLayout();
        content.setMargin(true);
        window.setResizable(false);
        window.center();
        window.setSizeUndefined();

        windowver.addComponent(idfield);
        windowver.addComponent(namefield);
        windowver.addComponent(pricefield);

        windowver1.addComponent(windowdishoption);
        windowver1.addComponent(glutenbox);
        windowver1.addComponent(windowcombobox);
        windowver1.addComponent(savebutton);

        windowhor.addComponent(windowver);
        windowhor.addComponent(windowver1);

        window.setContent(windowhor);
    }
}
