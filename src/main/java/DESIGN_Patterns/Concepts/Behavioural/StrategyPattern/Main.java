package DESIGN_Patterns.Concepts.Behavioural.StrategyPattern;

import DESIGN_Patterns.Concepts.Behavioural.StrategyPattern.Strategy.NormalDriveStrategy;
import DESIGN_Patterns.Concepts.Behavioural.StrategyPattern.Strategy.OffRoadDriveStrategy;
import DESIGN_Patterns.Concepts.Behavioural.StrategyPattern.Vehicle.OffRoadVehicle;
import DESIGN_Patterns.Concepts.Behavioural.StrategyPattern.Vehicle.Vehicle;

public class Main {

    public static void main(String args[]){

        Vehicle offRoadVehicle = new OffRoadVehicle(new OffRoadDriveStrategy());

        Vehicle sportsVehicle = new OffRoadVehicle(new NormalDriveStrategy());

        sportsVehicle.drive();
        offRoadVehicle.drive();
    }
}
