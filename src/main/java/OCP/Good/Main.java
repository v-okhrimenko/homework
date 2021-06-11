package OCP.Good;

import OCP.Good.DeliveryTypes.DeliveryByAir;
import OCP.Good.DeliveryTypes.DeliveryByCar;
import OCP.Good.DeliveryTypes.DeliveryByShip;

public class Main {
    public static void main(String[] args) {
        DeliveryByCar deliveryByCar = new DeliveryByCar("Lvov", "Kharkov");
        DeliveryByShip deliveryByShip = new DeliveryByShip("Odessa", "Kiev");
        DeliveryByAir deliveryByAir = new DeliveryByAir("Kiev", "New York");

        delivery(deliveryByCar);
        delivery(deliveryByShip);
        delivery(deliveryByAir);
    }

    private static void delivery(IDelivery delivery) {
        delivery.delivery();
    }
}
