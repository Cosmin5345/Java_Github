package exercitiu1;

public abstract class Vehicle {
    private String brand;
    private double speed;
    private static int nextId = 1;
    private final int id;
    private int mileage;
    private boolean rented;
    private int lastService;

    public Vehicle() {
        this.brand = "Necunoscut";
        this.speed = 0;
        this.id = nextId++;
        this.mileage = 0;
        this.rented = false;
        this.lastService = 0;
    }

    public Vehicle(String brand, double speed, int mileage, boolean rented, int lastService) {
        this.brand = brand;
        this.speed = speed;
        this.id = nextId++;
        this.mileage = mileage;
        this.rented = rented;
        this.lastService = lastService;
    }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public double getSpeed() { return speed; }
    public void setSpeed(double speed) { this.speed = speed; }

    public int getId() { return id; }
    public int getMileage() { return mileage; }
    public boolean isRented() { return rented; }

    public int getLastService() { return lastService; }
    public void setLastService(int lastService) { this.lastService = lastService; }

    public void sound() {
        System.out.println("Sunet necunoscut");
    }

    public void move() {
        this.speed += 20;
        System.out.println(brand + " se misca cu " + speed + " km/h");
    }

    public void rent() {
        if (rented)
            throw new IllegalStateException("Vehiculul este deja inchiriat");
        rented = true;
    }

    public void returnVehicle(int km) {
        if (!rented)
            throw new IllegalStateException("Vehiculul nu este inchiriat");
        if (km <= 0)
            throw new IllegalArgumentException("Kilometrii introdusi sunt invalizi");
        mileage += km;
        rented = false;
    }

    public abstract boolean needsService();
    public abstract double rentalPrice(int days);
}
