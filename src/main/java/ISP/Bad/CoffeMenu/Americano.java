package ISP.Bad.CoffeMenu;

import ISP.Bad.CoffeeMaker;

public class Americano implements CoffeeMaker {

    @Override
    public void addCoffee() {
        System.out.println("Add coffee");
    }

    @Override
    public void addWater() {
        System.out.println("Add 2 water ");
    }

    @Override
    public void addMilk() {
        // don't need use in this class
    }

    @Override
    public void makeCoffee() {
        addWater();
        addCoffee();
    }
}
