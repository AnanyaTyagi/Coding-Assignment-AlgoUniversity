package DESIGN_Patterns.Concepts.Behavioural.StrategyPattern.Vehicle;

import DESIGN_Patterns.Concepts.Behavioural.StrategyPattern.Strategy.DriveStrategy;

public class SportsVehicle extends Vehicle{
    SportsVehicle(DriveStrategy driveStrategy) {
        super(driveStrategy);
    }
}
