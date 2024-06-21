package DESIGN_Patterns.Concepts.Behavioural.StrategyPattern.Vehicle;

import DESIGN_Patterns.Concepts.Behavioural.StrategyPattern.Strategy.DriveStrategy;

public class GoodVehicle  extends  Vehicle{
    GoodVehicle(DriveStrategy driveStrategy) {
        super(driveStrategy);
    }
}
