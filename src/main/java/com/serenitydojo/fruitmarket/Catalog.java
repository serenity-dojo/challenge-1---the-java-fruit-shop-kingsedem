package com.serenitydojo.fruitmarket;
import com.serenitydojo.Fruit;

import java.util.*;
import java.util.stream.Collectors;


public  class Catalog {
    private Map<Fruit, Double> pricePerKilo = new HashMap<>();

    public PriceSetter setPriceOf(Fruit fruit){
        return new PriceSetter(this, fruit);
    }

    public Double getPriceOf(Fruit fruit){
        if(pricePerKilo.containsKey(fruit)){
            return pricePerKilo.get(fruit);
        } else {
            throw new FruitUnavailableException("Fruit unavailable: " + fruit);
        }
    }

    public List<String> listAvailableFruit() {
        Set<Fruit> currentlyAvailableFruit = pricePerKilo.keySet();

      return   currentlyAvailableFruit
                .stream()
                .map((fruit -> fruit.name()))
                .sorted()
                .collect(Collectors.toList());
    }


    public static class PriceSetter{
        private final Catalog catalog;
        private final Fruit fruit;


        public PriceSetter(Catalog catalog, Fruit fruit){
            this.catalog = catalog;
            this.fruit = fruit;
        }

        public Catalog to(Double price){
            catalog.pricePerKilo.put(fruit, price);
            return catalog;
        }

    }
}
