package DESIGN_Patterns.Concepts.Behavioural.ObserverPattern.Observable;

import DESIGN_Patterns.Concepts.Behavioural.ObserverPattern.Observer.NotificationAlertObserver;

public interface StockObservableInterface {

    void add(NotificationAlertObserver notificationAlertObserver);

    void remove(NotificationAlertObserver notificationAlertObserver);

    public void notifySubs();

    void setStockCount(int count);

    public int getStockCount();
}
