package pl.kmo2008.demo.Gui;

import pl.kmo2008.demo.App.Dish;
import pl.kmo2008.demo.App.Menu;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.server.*;
import com.vaadin.ui.*;
import com.vaadin.ui.Label;
import org.springframework.beans.factory.annotation.Autowired;
import pl.kmo2008.demo.Model.Categories;
import pl.kmo2008.demo.Model.Food;
import pl.kmo2008.demo.Repository.CategoriesRepository;
import pl.kmo2008.demo.Repository.FoodRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
     * Wired Food model.
     */
    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    CategoriesRepository catRepo;


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
        List<Food> foods = null;


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
        Grid<Food> grid = new Grid<>(Food.class);
        Button refreshbutton = new Button("Odśwież");
        Button addnew = new Button("Dodaj nowe danie");
        CheckBox glutenfree = new CheckBox("Glutenfree");
        Slider slider = new Slider();
        Label slidercount = new Label();
        ComboBox combo = new ComboBox<>("Wybierz język", lang);

        /**
         * Widnwos UI objects
         */
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

        grid.setWidth("100%");
        /**
         * Listeners
         */
        slider.addValueChangeListener(event -> {
            slidercount.setValue("Ilość wyświetlanych produktów: " + slider.getValue().intValue());
        });

        refreshbutton.addClickListener(clickEvent -> {
            Food food = null;
            boolean meat = false;
            boolean vegan = false;
            boolean gluten = false;
            int number = 0;
            String language = null;
            grid.getDataProvider().refreshAll();

            if (dishoption.isSelected("Mięsne")) meat = true;
            if (dishoption.isSelected("Wegetariańskie")) vegan = true;
            if (glutenfree.getValue()) gluten = true;
            number = slider.getValue().intValue();
            if (combo.isSelected("PL")) language = "PL";
            else if (combo.isSelected("EN")) language = "EN";
            else language = "All";
            System.out.println(meat + " " + vegan + " " + gluten + " " + number + " " + language);
            List<Food> foodlist = foodRepository.findAll();
            List<Food> readylist = new ArrayList<>();
            Categories catx = null;
            Iterator<Food> foodIterator = foodlist.iterator();
            while (foodIterator.hasNext()) {
                food = foodIterator.next();
                catx = catRepo.findOne(food.getCategory().getId());
                if (meat == catx.isMeat() && vegan == catx.isVegan() && gluten == catx.isGlutenfree() && number > 0) {
                    readylist.add(food);
                    number--;
                }
            }
            grid.setItems(readylist);
        });

        addnew.addClickListener(clickEvent ->
                addWindow(window)
        );


        /**
         * Subwindows action listener
         */
        savebutton.addClickListener(clickEvent -> {
            String namenew = namefield.getValue();
            double pricenew = Double.parseDouble(pricefield.getValue());
            boolean meatnew = false;
            boolean vegannew = false;
            boolean glutennew = false;
            int langnew = 0;
            if (windowdishoption.isSelected("Mięsne")) meatnew = true;
            else if (windowdishoption.isSelected("Wegetariańskie")) vegannew = true;
            if (glutenbox.getValue()) glutennew = true;
            Food food = new Food();
            Categories cat = new Categories();
            if (windowcombobox.isSelected("PL")) {
                food.setLang("PL");
            } else if (windowcombobox.isSelected("EN")) {
                food.setLang("EN");
            } else {
                food.setLang("All");
            }

            food.setName(namenew);
            food.setPrice(pricenew);
            cat.setMeat(meatnew);
            cat.setGlutenfree(glutennew);
            cat.setVegan(vegannew);
            catRepo.save(cat);
            food.setCategory(cat);
            foodRepository.save(food);
            Notification.show("Dodano nowe danie.", Notification.Type.TRAY_NOTIFICATION);
            window.close();

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
