package com.serenitydojo.fruitmarket;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.serenitydojo.Fruit.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TheCatalog  {

    //You can update the catalog with the current market price of a fruit
    @Test
    public void shouldBeAbleToUpdateTheCurrentPriceOfAFruit() {
        Catalog catalog = new Catalog();
        catalog.setPriceOf(Apple).to(4.00);
        assertThat(catalog.getPriceOf(Apple)).isEqualTo(4.00);
    }

    @Test
    public void shouldBeAbleToUpdateTheCurrentPriceOfAFruitOrange() {
        Catalog catalog = new Catalog();
        catalog.setPriceOf(Orange).to(5.50);
        assertThat(catalog.getPriceOf(Orange)).isEqualTo(5.50);
    }

    @Test
    public void shouldBeAbleToUpdateTheCurrentPriceOfAFruitBanana() {
        Catalog catalog = new Catalog();
        catalog.setPriceOf(Banana).to(6.00);
        assertThat(catalog.getPriceOf(Banana)).isEqualTo(6.00);
    }

    @Test
    public void shouldBeAbleToUpdateTheCurrentPriceOfAFruitPear() {
        Catalog catalog = new Catalog();
        catalog.setPriceOf(Pear).to(4.50);
        assertThat(catalog.getPriceOf(Pear)).isEqualTo(4.50);
    }



    //The Catalog should list the names of the currently available fruit in alphabetical order
    @Test
    public void shouldListFruitInAlphabeticalOrder(){
        Catalog catalog = new Catalog();
        catalog.setPriceOf(Apple).to(4.00);
        catalog.setPriceOf(Orange).to(5.50);
        catalog.setPriceOf(Banana).to(6.00);
        catalog.setPriceOf(Pear).to(4.50);

        List<String> fruit = catalog.listAvailableFruit();
        assertThat(fruit).containsExactly("Apple", "Banana", "Orange", "Pear");
    }

    //The Catalog should report the price of a given type of fruit
    @Test
    public void shouldReportTheValueOfAPieceOfFruit(){
        Catalog catalog = new Catalog();
        catalog.setPriceOf(Apple).to(4.00);

        Double price = catalog.getPriceOf(Apple);
        assertThat(price).isEqualTo(4.00);

    }

    //The Catalog should throw a FruitUnavailableException if the fruit is not currently available

    @Test(expected = FruitUnavailableException.class)
    public void shouldThrowAnExceptionIfAFruitIsNotAvailable(){
        Catalog catalog = new Catalog();
        catalog.setPriceOf(Apple).to(4.00);

        Double price = catalog.getPriceOf(Banana);
        assertThat(price).isEqualTo(4.00);

    }




}
