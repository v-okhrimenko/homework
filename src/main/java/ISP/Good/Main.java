package ISP.Good;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nAMERICANO:");
        Americano americano = new Americano();
        americano.makeCoffee();

        System.out.println("\nESPRESSO:");
        Espresso espresso = new Espresso();
        espresso.makeCoffee();

        System.out.println("\nAmericanoMilk:");
        AmericanoMilk americanoMilk = new AmericanoMilk();
        americanoMilk.makeCoffee();

        System.out.println("\nEspressoMilk:");
        EspressoMilk espressoMilk = new EspressoMilk();
        espressoMilk.makeCoffee();

        System.out.println("\nAMERICANO MILK TOPING:");
        AmericanoMilkTopping americanoMilkTopping = new AmericanoMilkTopping();
        americanoMilkTopping.makeCoffee();

    }
}
