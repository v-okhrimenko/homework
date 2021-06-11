package ISP.Good;

import ISP.Good.CoffeInterfaces.IMilk;

public class AmericanoMilk extends Americano implements IMilk {

    @Override
    public void makeCoffee() {
        super.makeCoffee();
        addMilk();
    }

    @Override
    public void addMilk() {
        System.out.println("Add milk");
    }
}
