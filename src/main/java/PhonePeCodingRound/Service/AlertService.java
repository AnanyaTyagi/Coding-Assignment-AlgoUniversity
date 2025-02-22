package PhonePeCodingRound.Service;

import PhonePeCodingRound.ConsoleStrategy;
import PhonePeCodingRound.DispatchFactory;
import PhonePeCodingRound.DispatchStrategy;
import PhonePeCodingRound.Model.AlertConfigListObject;
import PhonePeCodingRound.Model.DispatchStrategyList;
import PhonePeCodingRound.Model.Event;

public class AlertService {

    DispatchFactory dispatchFactory;

    public void dispatchAlert(AlertConfigListObject config) {

        for (DispatchStrategyList strategy : config.dispatchStrategyList) {
            dispatchFactory.getStrategy(strategy.type).dispatchAlert();
        }
    }

}
