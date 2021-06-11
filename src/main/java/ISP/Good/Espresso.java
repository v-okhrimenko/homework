package ISP.Good;

import ISP.Good.CoffeInterfaces.IEspresso;

public class Espresso implements IEspresso {
    @Override
    public void addCoffee() {
        System.out.println("Add 2 coffee");
    }

    @Override
    public void addWater() {
        System.out.println("Add water");
    }

    @Override
    public void makeCoffee() {
        addWater();
        addCoffee();
    }
}
