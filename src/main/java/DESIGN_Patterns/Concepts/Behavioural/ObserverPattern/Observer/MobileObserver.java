package DESIGN_Patterns.Concepts.Behavioural.ObserverPattern.Observer;

import DESIGN_Patterns.Concepts.Behavioural.ObserverPattern.Observable.StockObservableInterface;

public class MobileObserver implements NotificationAlertObserver{

    long mobileNumber;
    StockObservableInterface stockObservableInterface;

    public MobileObserver(long num, StockObservableInterface stockObservableInterface){
        this.mobileNumber = num;
        this.stockObservableInterface = stockObservableInterface;
    }
    @Override
    public void update() {
        System.out.println("The stock of the item is updated. Check it...");
    }
}
