package ISP.Good;

import ISP.Good.CoffeInterfaces.IMilk;

public class EspressoMilk extends Espresso implements IMilk {

    @Override
    public void addMilk() {
        System.out.println("Add milk");
    }

    @Override
    public void makeCoffee() {
        super.makeCoffee();
        addMilk();
    }

}
