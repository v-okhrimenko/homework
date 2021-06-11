package OCP.Bad;

public class DeliveryByCar extends Delivery {
    public DeliveryByCar(String fromCity, String toCity) {
        super(fromCity, toCity);
    }

    void deliveryByCar() {
        System.out.println("Delivery by car from " + super.getFromCity() + " to " + super.getToCity());
    }
}
