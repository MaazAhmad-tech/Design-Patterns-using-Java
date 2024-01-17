import withStrategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle{

    //sports vehicle will have sports driving strategy
    SportsVehicle()
    {
        super(new SportsDriveStrategy());
    }
}
