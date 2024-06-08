package DESIGN_Patterns.Concepts.Behavioural.ObserverPattern.Observable;

import DESIGN_Patterns.Concepts.Behavioural.ObserverPattern.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class SamsungObservableImpl implements StockObservableInterface{

    List<NotificationAlertObserver> observerList = new ArrayList<>();
    int stockSize = 0;

    @Override
    public void add(NotificationAlertObserver notificationAlertObserver) {
     observerList.add(notificationAlertObserver);
    }

    @Override
    public void remove(NotificationAlertObserver notificationAlertObserver) {
         observerList.remove(notificationAlertObserver);
    }

    @Override
    public void notifySubs() {
           for(NotificationAlertObserver observer:observerList){
                 observer.update();
           }
    }

    @Override
    public void setStockCount(int count) {
           this.stockSize = count;
           this.notifySubs();
    }

    @Override
    public int getStockCount() {
        return stockSize;
    }
}
