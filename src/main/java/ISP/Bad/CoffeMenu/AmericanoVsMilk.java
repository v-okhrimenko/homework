package ISP.Bad.CoffeMenu;

import ISP.Bad.CoffeeMaker;

public class AmericanoVsMilk implements CoffeeMaker {
    @Override
    public void addCoffee() {
        System.out.println("Add coffee");
    }

    @Override
    public void addWater() {
        System.out.println("Add 2 water");
    }

    @Override
    public void addMilk() {
        System.out.println("Add milk");
    }

    @Override
    public void makeCoffee() {
        addWater();
        addCoffee();
        addMilk();
    }
}
