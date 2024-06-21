package DESIGN_Patterns.Concepts.Behavioural.StrategyPattern.Vehicle;

import DESIGN_Patterns.Concepts.Behavioural.StrategyPattern.Strategy.DriveStrategy;

public class Vehicle {

    DriveStrategy driveStrategy;

    Vehicle(DriveStrategy driveStrategy){
        this.driveStrategy = driveStrategy;
    }

    public void drive(){
        driveStrategy.drive();
    }

}
