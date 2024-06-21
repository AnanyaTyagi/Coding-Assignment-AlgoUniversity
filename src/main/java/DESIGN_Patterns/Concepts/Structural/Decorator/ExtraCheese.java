package DESIGN_Patterns.Concepts.Structural.Decorator;

public class ExtraCheese extends ToppingDecorator{
    BasePizza basePizza;
    
    ExtraCheese(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return basePizza.cost()+50;
    }
}