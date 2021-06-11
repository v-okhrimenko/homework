package ISP.Bad.CoffeMenu;

import ISP.Bad.CoffeeMaker;

public class Espresso implements CoffeeMaker {
    @Override
    public void addCoffee() {
        System.out.println("Add coffee");
    }

    @Override
    public void addWater() {
        System.out.println("Add water");
    }

    @Override
    public void addMilk() {
        // don't need use in this class
    }

    @Override
    public void makeCoffee() {
        addCoffee();
        addWater();
    }
}
