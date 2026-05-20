package exercitiu1;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", 0, 5000, false, 0, 4);
        Car car2 = new Car("Dacia", 0, 12000, false, 0, 2);
        Motorcycle moto1 = new Motorcycle("Honda", 0, 7000, false, 0, false);
        Motorcycle moto2 = new Motorcycle("Yamaha", 0, 3000, false, 0, true);
        Truck truck = new Truck("Volvo", 0, 20000, false, 0, 8000);

        Vehicle[] fleet = new Vehicle[]{car1, car2, moto1, moto2, truck};
        for (Vehicle v : fleet)
            v.move();

        System.out.println("car1 equals car2: " + car1.equals(car2));

        Garage garage = new Garage(10);
        for (Vehicle v : fleet)
            garage.add(v);

        garage.rentById(car1.getId());
        garage.rentById(moto2.getId());

        garage.printAvailable();
        garage.printNeedsService();
        garage.printRentalEstimate(truck.getId(), 5);

        garage.returnById(car1.getId(), 300);
        garage.returnById(moto2.getId(), 150);
    }
}
