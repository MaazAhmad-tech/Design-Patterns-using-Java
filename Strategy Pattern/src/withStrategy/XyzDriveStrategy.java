package withStrategy;

/**
 * Here we can see that we can add new functionality of a Strategy when the requirement comes. The underlying code shall not be modified in order to add new drive functionality
 * */
public class XyzDriveStrategy implements DriveStrategy{

    @Override
    public void drive() {
        System.out.println("XYZ Drive Strategy");
    }
}
