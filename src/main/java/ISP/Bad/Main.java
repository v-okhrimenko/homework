package ISP.Bad;

import ISP.Bad.CoffeMenu.Americano;
import ISP.Bad.CoffeMenu.AmericanoVsMilk;
import ISP.Bad.CoffeMenu.Dopio;
import ISP.Bad.CoffeMenu.Espresso;

public class Main {
    public static void main(String[] args) {
        System.out.println("AMERICANO:");
        Americano americano = new Americano();
        americano.makeCoffee();

        System.out.println("\nESPRESSO:");
        Espresso espresso = new Espresso();
        espresso.makeCoffee();

        System.out.println("\nAMERICANO AND MILK:");
        AmericanoVsMilk americanoVsMilk = new AmericanoVsMilk();
        americanoVsMilk.makeCoffee();

        System.out.println("\nDOPIO:");
        Dopio dopio = new Dopio();
        dopio.makeCoffee();


    }
}
