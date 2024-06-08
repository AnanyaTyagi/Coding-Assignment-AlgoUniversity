package DESIGN_Patterns.Concepts.Behavioural.ObserverPattern;

import DESIGN_Patterns.Concepts.Behavioural.ObserverPattern.Observable.SamsungObservableImpl;
import DESIGN_Patterns.Concepts.Behavioural.ObserverPattern.Observable.StockObservableInterface;
import DESIGN_Patterns.Concepts.Behavioural.ObserverPattern.Observer.EmailObserver;
import DESIGN_Patterns.Concepts.Behavioural.ObserverPattern.Observer.MobileObserver;
import DESIGN_Patterns.Concepts.Behavioural.ObserverPattern.Observer.NotificationAlertObserver;

public class Store {

    public static void main(String args[]){
        StockObservableInterface stockObservableInterface = new SamsungObservableImpl();

        NotificationAlertObserver mobileObserver1 = new MobileObserver(7217615643L, stockObservableInterface);
        NotificationAlertObserver emailObserverone = new EmailObserver("ananya.tyagi@gmail.com", stockObservableInterface);
        NotificationAlertObserver emailObserverTwo = new EmailObserver("saumay.tyagi@gmail.com", stockObservableInterface);

        stockObservableInterface.add(mobileObserver1);
        stockObservableInterface.add(emailObserverone);
        stockObservableInterface.add(emailObserverTwo);
        stockObservableInterface.setStockCount(10);
    }
}
