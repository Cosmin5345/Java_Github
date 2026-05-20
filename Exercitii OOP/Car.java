package exercitiu1;

public class Car extends Vehicle {
    private int numDoors;

    public Car() {}

    public Car(String brand, double speed, int mileage, boolean rented, int lastService, int numDoors) {
        super(brand, speed, mileage, rented, lastService);
        this.numDoors = numDoors;
    }

    public int getNumDoors() { return numDoors; }

    @Override
    public void sound() {
        System.out.println("Vroom vroom");
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
        if (getMileage() - getLastService() >= 10000) {
            setLastService(getMileage());
            return true;
        }
        return false;
    }

    @Override
    public double rentalPrice(int days) {
        double base = 50 * days;
        return numDoors >= 4 ? base * 1.1 : base;
    }
}
