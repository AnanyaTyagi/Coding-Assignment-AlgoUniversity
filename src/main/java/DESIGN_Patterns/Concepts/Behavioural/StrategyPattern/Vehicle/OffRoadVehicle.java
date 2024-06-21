package DESIGN_Patterns.Concepts.Behavioural.StrategyPattern.Vehicle;

import DESIGN_Patterns.Concepts.Behavioural.StrategyPattern.Strategy.DriveStrategy;

public class OffRoadVehicle extends Vehicle{

    public OffRoadVehicle(DriveStrategy driveStrategy) {
        super(driveStrategy);
    }
}
