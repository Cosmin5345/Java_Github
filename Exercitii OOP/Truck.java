package exercitiu1;

public class Truck extends Vehicle {
    private int capacity;

    public Truck() {}

    public Truck(String brand, double speed, int mileage, boolean rented, int lastService, int capacity) {
        super(brand, speed, mileage, rented, lastService);
        this.capacity = capacity;
    }

    public int getCapacity() { return capacity; }

    @Override
    public void sound() {
        System.out.println("Sunet de camion");
    }

    @Override
    public boolean needsService() {
        if (getMileage() - getLastService() >= 15000) {
            setLastService(getMileage());
            return true;
        }
        return false;
    }

    @Override
    public double rentalPrice(int days) {
        return (80 + 0.02 * capacity) * days;
    }
}
