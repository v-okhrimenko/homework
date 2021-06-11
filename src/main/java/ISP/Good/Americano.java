package ISP.Good;

import ISP.Good.CoffeInterfaces.IAmericano;

public class Americano implements IAmericano {
    @Override
    public void addCoffee() {
        System.out.println("Add coffee");
    }

    @Override
    public void addWater() {
        System.out.println("Add 2 water");
    }

    @Override
    public void makeCoffee() {
        addCoffee();
        addWater();
    }
}
