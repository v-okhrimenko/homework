package OCP.Good;

public abstract class Delivery {
    private String fromCity;
    private String toCity;

    public Delivery(String fromCity, String toCity) {
        this.fromCity = fromCity;
        this.toCity = toCity;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }
}
