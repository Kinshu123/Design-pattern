interface Vehicle {
    void info();
}

class Car implements Vehicle {
    @Override
    public void info() {
        System.out.println("This is a Car");
    }
}

class Bike implements Vehicle {
    @Override
    public void info() {
        System.out.println("This is a Bike");
    }
}

class Truck implements Vehicle {
    @Override
    public void info() {
        System.out.println("This is a Truck");
    }
}

class VehicleFactory {
    public static Vehicle createVehicle(String type) {
        switch (type.toLowerCase()) {
            case "car":
                return new Car();
            case "bike":
                return new Bike();
            case "truck":
                return new Truck();
            default:
                throw new IllegalArgumentException("Unknown vehicle type");
        }
    }
}

public class VehicleFactoryMethod {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.createVehicle("car");
        car.info();  // This is a Car

        Vehicle bike = VehicleFactory.createVehicle("bike");
        bike.info();  // This is a Bike
    }
}
