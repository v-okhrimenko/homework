package OCP.Good.DeliveryTypes;

import OCP.Good.Delivery;
import OCP.Good.IDelivery;

public class DeliveryByCar extends Delivery implements IDelivery {
    public DeliveryByCar(String fromCity, String toCity) {
        super(fromCity, toCity);
    }

    @Override
    public void delivery() {
        System.out.println("Delivery by car from " + super.getFromCity() + " to " + super.getToCity());
    }
}
