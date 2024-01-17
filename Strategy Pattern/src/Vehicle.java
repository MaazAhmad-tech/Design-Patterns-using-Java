import withStrategy.DriveStrategy;

public class Vehicle {

    //Vehicle has a driving strategy
    DriveStrategy driveStrategy;

    public Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void drive()
    {
        driveStrategy.drive();
    }
}
