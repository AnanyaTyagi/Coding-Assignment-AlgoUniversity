package DESIGN_Patterns.Concepts.Structural.Decorator;

public class PizzaDecorator {

    public static void main(String[] args) {
        BasePizza farmhouse = new FarmhousePizza();
        BasePizza margharittaPizza = new MargharittaPizza();
        System.out.println(new ExtraCheese(new ExtraMushroom(margharittaPizza)).cost());
        System.out.println(new ExtraCheese(new ExtraMushroom(farmhouse)).cost());
    }
}
