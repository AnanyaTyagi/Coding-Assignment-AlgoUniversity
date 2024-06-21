package DESIGN_Patterns.Concepts.Behavioural.StrategyPattern.Strategy;

public class OffRoadDriveStrategy implements DriveStrategy{


    @Override
    public void drive() {
        System.out.println("OffRoad Drive Strategy");

    }
}
