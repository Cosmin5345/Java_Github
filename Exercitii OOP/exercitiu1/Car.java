package exercitiu1;

public class Car extends Vehicle {
    private int numDoors;

    public Car(String id, String brand, double speed, int numDoors) {
        super(id, brand, speed);
        this.numDoors = numDoors;
    }

    @Override
    public void sound() {
        System.out.println("PO PO PO PO PO(cu flacara)");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Car other = (Car) obj;
        return getBrand().equals(other.getBrand()) && getSpeed() == other.getSpeed();
    }

    @Override
    public boolean needsService() {
        return getMileage() >= 10000;
    }

    @Override
    public double rentalPrice(int days) {
        double price = 50 * days;
        if (numDoors >= 4) {
            price *= 1.1;
        }
        return price;
    }
}