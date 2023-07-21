package oop_java ;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import OOP_java_sem1.Automat;
import OOP_java_sem1.Beverage;
import OOP_java_sem1.Food;
import OOP_java_sem1.Hot_beverage;
import OOP_java_sem1.Product;

public class Human extends Actor{

    private double money;
    private Automat nearestAutomat;

    public Human(String name1, boolean make_order1, boolean take_order1, double money) {
        super(name1, make_order1, take_order1);
        this.money = money;
    }
    public double getMoney() {
        return money;
    }
    public void setMoney(double money) {
        this.money = money;
    }
    @Override
    public void setTake_order( boolean b) {
        // TODO Auto-generated method stub
        }

    @Override
    public void setMake_order(boolean d) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean getTook_order() {
        return false;
    }

    @Override
    public boolean getMade_order() {
        return false;
    }


    public void findNearestAutomat() {

        ArrayList <Product> my_list = new ArrayList<>();
        my_list.add(new Food("Twix", 80, 10, new GregorianCalendar(2026, 10, 15, 0, 0),80));
        my_list.add(new Food("Mars", 90, 9, new GregorianCalendar(2026, 10,0, 0, 0), 150));
        my_list.add(new Food("Snickers", 60, 15, new GregorianCalendar(2026, 10,0, 0, 0),150));
        my_list.add(new Food("Bounty", 85, 18, new GregorianCalendar(2026, 9, 13, 0, 0, 0), 120));
        my_list.add(new Beverage("Coca-Cola", 150, 7, new GregorianCalendar(2026, 3, 8, 0, 0, 0), 0.33));
        my_list.add(new Hot_beverage("Nesсafe", 150, 35, 
                    new GregorianCalendar(2024, 5, 12, 0, 0, 0), 0.33, 25));
        my_list.add(new Hot_beverage("Jacobs", 120, 3, 
                    new GregorianCalendar(2024, 6, 07, 0, 0, 0), 0.33, 20));
        my_list.add(new Hot_beverage("Bushido", 170, 12, 
                    new GregorianCalendar(2024, 03, 11, 0, 0, 0), 0.33, 25));

        Automat automat = new Automat();
        automat.initProduct(my_list);
        this.nearestAutomat = automat;
    }
    @Override    
    public Order makeOrder(List <String> deList ) {
        ArrayList <Product> shoppingList = new ArrayList<>();
        Product shoppingProduct;
        for (String nameProduct : deList) {
            shoppingProduct = nearestAutomat.getProduct(nameProduct);
            if (shoppingProduct!= null ){
                shoppingList.add(shoppingProduct);  
            } 
        }
        setMade_order(true); 
        return nearestAutomat.createOrder(shoppingList);
    }
}