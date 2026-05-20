package exercitiu1;

public class Garage {
    private Vehicle[] fleet;
    private int size;

    public Garage(int capacity) {
        this.fleet = new Vehicle[capacity];
        this.size = 0;
    }

    public void add(Vehicle v) {
        if (size == fleet.length) {
            throw new IllegalStateException("Garajul este plin");
        }
        if (findById(v.getId()) != null) {
            throw new IllegalArgumentException("Vehiculul cu acest ID exista deja");
        }
        fleet[size++] = v;
    }

    public Vehicle findById(String id) {
        for (int i = 0; i < size; i++) {
            if (fleet[i].getId().equals(id)) {
                return fleet[i];
            }
        }
        return null;
    }

    public void rentById(String id) {
        Vehicle v = findById(id);
        if (v == null) {
            throw new IllegalArgumentException("Vehiculul nu a fost gasit");
        }
        v.rent();
    }

    public void returnById(String id, int drivenKm) {
        Vehicle v = findById(id);
        if (v == null) {
            throw new IllegalArgumentException("Vehiculul nu a fost gasit");
        }
        v.returnVehicle(drivenKm);
    }

    public void printAvailable() {
        System.out.println("Vehicule disponibile:");
        for (int i = 0; i < size; i++) {
            if (!fleet[i].isRented()) {
                System.out.println("ID: " + fleet[i].getId() + " - " + fleet[i].getBrand());
            }
        }
    }

    public void printNeedsService() {
        System.out.println("Vehicule care au nevoie de service:");
        for (int i = 0; i < size; i++) {
            if (fleet[i].needsService()) {
                System.out.println("ID: " + fleet[i].getId() + " - " + fleet[i].getBrand());
            }
        }
    }

    public void printRentalEstimate(String id, int days) {
        Vehicle v = findById(id);
        if (v == null) {
            throw new IllegalArgumentException("Vehiculul nu a fost gasit");
        }
        System.out.println("Pret estimat inchiriere: " + v.rentalPrice(days));
    }
}