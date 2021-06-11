package OCP.Bad;

public class Main {
    public static void main(String[] args) {
        DeliveryByCar deliveryByCar = new DeliveryByCar("Kiev", "Odessa");
        DeliveryByShip deliveryByShip = new DeliveryByShip("Lutsk", "Kovel");

        delivery(deliveryByCar);
        delivery(deliveryByShip);
    }

    public static void delivery(Delivery delivery) {
        if (delivery instanceof DeliveryByCar) {
            ((DeliveryByCar) delivery).deliveryByCar();
        }
        if (delivery instanceof DeliveryByShip) {
            ((DeliveryByShip) delivery).deliveryByShip();
        }
        /// add many IF for new delivery types...
    }
}

