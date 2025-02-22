package PhonePeCodingRound.Service;

import PhonePeCodingRound.Model.AlertConfigListObject;
import PhonePeCodingRound.Model.DispatchStrategyList;
import PhonePeCodingRound.Model.Event;

import java.util.*;
import java.util.concurrent.*;

public class MonitoringService {

    private ArrayList<AlertConfigListObject> configList;
    private ConcurrentHashMap<String, List<Event>> eventMap;
    private ExecutorService executorService;
    private static long windowStartTime = 10000000;
    private AlertService alertService = new AlertService();
//     public void resetWindowTime(){
//while(1){
//
//    Thread.sleep(10000);
//    windowStartTime.
//}
//     }

    public MonitoringService(ArrayList<AlertConfigListObject> configList) {
        this.configList = configList;
        this.eventMap = new ConcurrentHashMap<>();
        this.executorService = Executors.newCachedThreadPool();
    }

    public void recordEvent(Event event) {
        eventMap.computeIfAbsent(event.getEventType(), k -> Collections.synchronizedList(new ArrayList<>())).add(event);
        executorService.submit(() -> processEvent(event));
    }

    private void processEvent(Event event) {
        for (AlertConfigListObject config : configList) {
            if (config.client.equals(event.getClient()) && config.eventType.equals(event.getEventType())) {
                if (config.alertConfig.type.equals("TUMBLING_WINDOW")) {
                    handleTumblingWindow(event, config);
                } else if (config.alertConfig.type.equals("SLIDING_WINDOW")) {
                    handleSlidingWindow(event, config);
                }
            }
        }
    }

    private void handleTumblingWindow(Event event, AlertConfigListObject config) {
        long windowSizeInMillis = config.alertConfig.windowSizeInSecs * 1000;
        long currentTime = System.currentTimeMillis();
        long windowStartTime = currentTime - (currentTime % windowSizeInMillis);

        List<Event> events = eventMap.get(event.getEventType());
        long count = events.stream().filter(e -> e.getTimestamp() >= windowStartTime).count();

        System.out.println("[INFO] MonitoringService: Client " + config.client + " " + config.eventType + " TUMBLING_WINDOW starts");
        if (count >= config.alertConfig.count) {
            System.out.println("[INFO] MonitoringService: Client " + config.client + " " + config.eventType + " threshold breached");
            alertService.dispatchAlert(config);
        }
        System.out.println("[INFO] MonitoringService: Client " + config.client + " " + config.eventType + " TUMBLING_WINDOW ends");
    }

    private void handleSlidingWindow(Event event, AlertConfigListObject config) {
        long windowSizeInMillis = config.alertConfig.windowSizeInSecs * 1000;
        long currentTime = System.currentTimeMillis();
        long windowStartTime = currentTime - windowSizeInMillis;

        List<Event> events = eventMap.get(event.getEventType());
        long count = events.stream().filter(e -> e.getTimestamp() >= windowStartTime).count();

        if (count >= config.alertConfig.count) {
            System.out.println("[INFO] MonitoringService: Client " + config.client + " " + config.eventType + " threshold breached");
            alertService.dispatchAlert(config);
        }
    }

//    private void dispatchAlert(AlertConfigListObject config) {
//        for (DispatchStrategyList strategy : config.dispatchStrategyList) {
//            if ("CONSOLE".equals(strategy.type)) {
//                System.out.println("[INFO] AlertingService: Dispatching to Console");
//                System.out.println("[WARN] Alert: `" + strategy.message + "`");
//            } else if ("EMAIL".equals(strategy.type)) {
//                System.out.println("[INFO] AlertingService: Dispatching an Email");
//                System.out.println("[INFO] Email Subject: `" + strategy.subject + "`");
//            }
//        }
//    }
}
