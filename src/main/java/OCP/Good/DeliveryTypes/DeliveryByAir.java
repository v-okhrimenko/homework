package OCP.Good.DeliveryTypes;

import OCP.Good.Delivery;
import OCP.Good.IDelivery;

public class DeliveryByAir extends Delivery implements IDelivery {
    public DeliveryByAir(String fromCity, String toCity) {
        super(fromCity, toCity);
    }

    @Override
    public void delivery() {
        System.out.println("Air delivery from " + super.getFromCity() + " to " + super.getToCity());
    }
}
