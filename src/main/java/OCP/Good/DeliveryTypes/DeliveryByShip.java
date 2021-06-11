package OCP.Good.DeliveryTypes;

import OCP.Good.Delivery;
import OCP.Good.IDelivery;

public class DeliveryByShip extends Delivery implements IDelivery {
    public DeliveryByShip(String fromCity, String toCity) {
        super(fromCity, toCity);
    }

    @Override
    public void delivery() {
        System.out.println("Delivery by ship from " + super.getFromCity() + " to " + super.getToCity());
    }
}
