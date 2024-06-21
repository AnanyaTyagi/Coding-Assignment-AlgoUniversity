package DESIGN_Patterns.Concepts.Structural.Decorator;

public class ExtraMushroom extends ToppingDecorator{
    BasePizza basePizza;

    ExtraMushroom(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return basePizza.cost()+25;
    }
}
