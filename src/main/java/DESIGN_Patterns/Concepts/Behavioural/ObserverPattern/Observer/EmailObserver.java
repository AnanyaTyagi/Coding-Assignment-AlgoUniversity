package DESIGN_Patterns.Concepts.Behavioural.ObserverPattern.Observer;

import DESIGN_Patterns.Concepts.Behavioural.ObserverPattern.Observable.StockObservableInterface;

public class EmailObserver implements NotificationAlertObserver{

    String email;
    StockObservableInterface stockObservableInterface;

    public EmailObserver(String email, StockObservableInterface stockObservableInterface){
        this.email = email;
        this.stockObservableInterface = stockObservableInterface;
    }
    @Override
    public void update() {
      System.out.println("The stock of the item is updated. Check it...");
    }
}
