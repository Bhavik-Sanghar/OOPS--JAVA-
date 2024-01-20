

// Car class representing a basic car
class Car {
    // Instance variables
    String make;
    String model;
    int year;
    int price;

    // Constructor to initialize the car details
    public Car(String make, String model, int year, int price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    // Display information about the car
    public void displayInfo() {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Price: " + price);
    }

    // Calculate depreciation based on the number of years
    public void calculateDepreciation(int years) {
        // Example formula: Depreciation = (10% * original value) * years
        System.out.println("Depreciation: " + (0.1 * price) * years);
    }

    // Calculate depreciation based on the percentage depreciation
    public void calculateDepreciation(double percentageDepreciation) {
        // Example formula: Depreciation = percentageDepreciation * original value
        System.out.println("Depreciation: " + percentageDepreciation * price);
    }
}

// ElectricCar class extending the Car class
class ElectricCar extends Car {
    // Additional attribute for electric cars
    double batteryCapacity;

    // Constructor to initialize electric car details
    public ElectricCar(String make, String model, int year, int price, double batteryCapacity) {
        super(make, model, year, price);
        this.batteryCapacity = batteryCapacity;
    }

    // Override the displayInfo method to include battery capacity
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call the superclass method
        System.out.println("Battery Capacity: " + batteryCapacity);
    }
}

// Main program to test the Car and ElectricCar classes
public class Test1 {
    public static void main(String[] args) {
        // Create instances of Car and ElectricCar
        Car car1 = new Car("Toyota", "Camry", 2022, 50000);
        Car car2 = new Car("Honda", "Civic", 2021, 10000);
        ElectricCar car3 = new ElectricCar("Tesla", "x", 2024, 20000, 50.25);

        // Display information and calculate depreciation for each car
        car1.displayInfo();
        car1.calculateDepreciation(5);
        car1.calculateDepreciation(3.25);
        System.out.println(); // Just to separate the outputs
        car2.displayInfo();
        System.out.println();
        car3.displayInfo();
    }
}
 