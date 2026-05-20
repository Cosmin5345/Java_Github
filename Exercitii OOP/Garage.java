package exercitiu1;

public class Garage {
    private Vehicle[] vehicles;
    private int count;

    public Garage(int capacity) {
        this.vehicles = new Vehicle[capacity];
        this.count = 0;
    }

    public int getCount() { return count; }

    public void add(Vehicle v) {
        if (count == vehicles.length)
            throw new IllegalStateException("Garajul este plin");
        for (int i = 0; i < count; i++)
            if (vehicles[i].getId() == v.getId())
                throw new IllegalArgumentException("Vehiculul exista deja in garaj");
        vehicles[count++] = v;
    }

    public Vehicle findById(int id) {
        for (int i = 0; i < count; i++)
            if (vehicles[i].getId() == id)
                return vehicles[i];
        return null;
    }

    public void rentById(int id) {
        Vehicle v = findById(id);
        if (v == null)
            throw new IllegalArgumentException("Vehiculul nu a fost gasit");
        v.rent();
    }

    public void returnById(int id, int km) {
        Vehicle v = findById(id);
        if (v == null)
            throw new IllegalArgumentException("Vehiculul nu a fost gasit");
        v.returnVehicle(km);
    }

    public void printAvailable() {
        System.out.println("Vehicule disponibile:");
        for (int i = 0; i < count; i++)
            if (!vehicles[i].isRented())
                System.out.println("  ID " + vehicles[i].getId() + " - " + vehicles[i].getBrand());
    }

    public void printNeedsService() {
        System.out.println("Vehicule care necesita service:");
        for (int i = 0; i < count; i++)
            if (vehicles[i].needsService())
                System.out.println("  ID " + vehicles[i].getId() + " - " + vehicles[i].getBrand());
    }

    public void printRentalEstimate(int id, int days) {
        Vehicle v = findById(id);
        if (v == null) {
            System.out.println("Vehiculul nu a fost gasit");
            return;
        }
        System.out.println("Pret inchiriere pentru " + days + " zile: " + v.rentalPrice(days) + " RON");
    }
}
