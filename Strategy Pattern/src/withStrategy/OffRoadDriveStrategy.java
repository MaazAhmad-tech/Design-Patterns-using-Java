package withStrategy;

public class OffRoadDriveStrategy implements DriveStrategy {

    @Override
    public void drive() {
        System.out.println("OffRoad drive Strategy");
    }
}
