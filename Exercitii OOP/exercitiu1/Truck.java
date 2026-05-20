package exercitiu1;

public class Truck extends Vehicle {
    private int loadCapacity;

    public Truck(String id, String brand, double speed, int loadCapacity) {
        super(id, brand, speed);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void sound() {
        System.out.println("(*conserve in remorca)");
    }

    @Override
    public boolean needsService() {
        return getMileage() >= 15000;
    }

    @Override
    public double rentalPrice(int days) {
        return (80 + 0.02 * loadCapacity) * days;
    }
}