package com.serenitydojo.fruitmarket;

import org.junit.Before;
import org.junit.Test;

import static com.serenitydojo.Fruit.*;
import static com.serenitydojo.Fruit.Pear;
import static org.assertj.core.api.Assertions.assertThat;

public class TheShoppingCart {

    Catalog catalog;

    @Before

    public void createCatalog(){
        catalog = new Catalog();
        catalog.setPriceOf(Apple).to(4.00);
        catalog.setPriceOf(Orange).to(5.50);
        catalog.setPriceOf(Banana).to(6.00);
        catalog.setPriceOf(Pear).to(4.50);
    }
    //You can add items to your shopping cart, which should keep a running total.
    @Test
    public void shouldStartWithNoItemsInIt(){
        ShoppingCart  cart = new ShoppingCart(catalog);
        assertThat(cart.getItems()).isEmpty();
    }

    @Test
    public void shouldLetYouAddItems(){
        ShoppingCart  cart = new ShoppingCart(catalog);
        cart.addItem(3, Apple);
        cart.addItem(4, Banana);

        assertThat(cart.getItems()).hasSize(2);

    }



//    @Test
//    public void shouldKeepARunningTotalOfTheCost(){
//        ShoppingCart  cart = new ShoppingCart(catalog);
//        cart.addItem(3, Apple);
//        cart.addItem(4, Banana);
//
//       // assertThat(cart.getTotalCost()).isEqualTo(19.50);
//
//    }


//    @Test
//    public void shouldGiveA10PercentFor5KiloOrMore(){
//        ShoppingCart  cart = new ShoppingCart(catalog);
//        cart.addItem(3, Apple);
//        cart.addItem(4, Banana);
//
//        // assertThat(cart.getTotalCost()).isEqualTo(19.50);
//
//    }

}
