package exercitiu1;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("C1", "Fiat Panda(Manager de mediu)", 50, 4);
        Car car2 = new Car("C2", "Fiat 500", 50, 2);
        Motorcycle moto1 = new Motorcycle("M1", "Honda", 60, false);
        Motorcycle moto2 = new Motorcycle("M2", "Yamaha", 70, true);
        Truck truck1 = new Truck("T1", "Volvo", 40, 10000);

        Vehicle[] vehicles = new Vehicle[]{car1, car2, moto1, moto2, truck1};
        for (Vehicle v : vehicles) {
            v.move();
            v.sound();
        }

        System.out.println("Comparare car1 si car2 prin metoda .equals(): " + car1.equals(car2));

        Garage garage = new Garage(10);
        garage.add(car1);
        garage.add(car2);
        garage.add(moto1);
        garage.add(moto2);
        garage.add(truck1);

        garage.rentById("C1");
        garage.rentById("M2");

        garage.printAvailable();
        garage.printNeedsService();
        garage.printRentalEstimate("T1", 5);
    }
}