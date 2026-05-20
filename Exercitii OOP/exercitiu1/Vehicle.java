package exercitiu1;

public abstract class Vehicle {
    private String brand;
    private double speed;
    private final String id;
    private int mileage;
    private boolean rented;

    public Vehicle(String id, String brand, double speed) {
        this.id = id;
        this.brand = brand;
        this.speed = speed;
        this.mileage = 0;
        this.rented = false;
    }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public double getSpeed() { return speed; }
    public void setSpeed(double speed) { this.speed = speed; }

    public String getId() { return id; }
    public int getMileage() { return mileage; }
    public boolean isRented() { return rented; }

    public void move() {
        this.speed += 20;
        System.out.println(brand + " se misca cu " + speed + " km/h");
    }

    public void rent() {
        if (rented) {
            throw new IllegalStateException("Vehiculul este deja inchiriat");
        }
        rented = true;
    }

    public void returnVehicle(int drivenKm) {
        if (!rented) {
            throw new IllegalStateException("Vehiculul nu este inchiriat");
        }
        if (drivenKm <= 0) {
            throw new IllegalArgumentException("Kilometrii introdusi trebuie sa fie > 0");
        }
        this.mileage += drivenKm;
        this.rented = false;
    }

    public abstract void sound();
    public abstract boolean needsService();
    public abstract double rentalPrice(int days);
}