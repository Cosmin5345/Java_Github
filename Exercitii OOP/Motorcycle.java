package exercitiu1;

public class Motorcycle extends Vehicle {
    private boolean sidecar;

    public Motorcycle() {}

    public Motorcycle(String brand, double speed, int mileage, boolean rented, int lastService, boolean sidecar) {
        super(brand, speed, mileage, rented, lastService);
        this.sidecar = sidecar;
    }

    public boolean hasSidecar() { return sidecar; }

    @Override
    public void sound() {
        System.out.println("Sunet de motocicleta");
    }

    @Override
    public boolean needsService() {
        if (getMileage() - getLastService() >= 6000) {
            setLastService(getMileage());
            return true;
        }
        return false;
    }

    @Override
    public double rentalPrice(int days) {
        return sidecar ? (30 + 15) * days : 30 * days;
    }
}
