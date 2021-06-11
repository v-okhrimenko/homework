package ISP.Good;

import ISP.Good.CoffeInterfaces.IToping;

public class AmericanoMilkTopping extends AmericanoMilk implements IToping {
    @Override
    public void addToping() {
        System.out.println("Add toping to coffee");
    }

    @Override
    public void makeCoffee() {
        super.makeCoffee();
        addToping();
    }
}
