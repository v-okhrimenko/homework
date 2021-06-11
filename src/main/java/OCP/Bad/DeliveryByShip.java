package OCP.Bad;

public class DeliveryByShip extends Delivery {
    public DeliveryByShip(String fromCity, String toCity) {
        super(fromCity, toCity);
    }

    void deliveryByShip() {
        System.out.println("Delivery by ship" +
                " from " + super.getFromCity() + " to " + super.getToCity());
    }
}
