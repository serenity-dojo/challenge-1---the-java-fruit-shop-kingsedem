package com.serenitydojo.fruitmarket;

import com.serenitydojo.Fruit;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final Catalog catalog;
    private final List<ShoppingCartItem> items;
    public ShoppingCart(Catalog catalog) {
        this.catalog = catalog;
        this.items = new ArrayList<>();
    }


    public List<ShoppingCartItem> getItems() {
      return items;
    }

    public void addItem(double quantityInKg, Fruit fruit) {
        double totalPrice = catalog.getPriceOf(fruit) * quantityInKg;
        if(quantityInKg >=5 ){
            totalPrice = totalPrice * 0.9;
        }
        items.add(
                new ShoppingCartItem(fruit, quantityInKg, totalPrice)
        );

}



//    public double getTotalCost() {
//        return items.stream()
//                 .mapToDouble(items -> items.getTotalCost())
//                .sum();
//    }


}