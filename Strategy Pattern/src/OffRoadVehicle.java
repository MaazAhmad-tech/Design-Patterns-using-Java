import withStrategy.DriveStrategy;
import withStrategy.OffRoadDriveStrategy;

public class OffRoadVehicle extends Vehicle {

    //Here we are passing offRoad drive strategy dynamically, similarly we can pass whatever strategy we want.
    public OffRoadVehicle() {
        super(new OffRoadDriveStrategy());
    }
}
