package PhonePeCodingRound;

import PhonePeCodingRound.Model.AlertConfig;
import PhonePeCodingRound.Model.AlertConfigListObject;
import PhonePeCodingRound.Model.DispatchStrategyList;
import PhonePeCodingRound.Model.Event;
import PhonePeCodingRound.Service.MonitoringService;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


class Main {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<AlertConfigListObject> configList = getConfigList();
        MonitoringService monitoringService = new MonitoringService(configList);

        for (int i = 0; i < 20; i++) {
            long currentTime = System.currentTimeMillis();
            new Thread(() -> {
                monitoringService.recordEvent(new Event("X", "PAYMENT_EXCEPTION", currentTime));
                monitoringService.recordEvent(new Event("X", "USERSERVICE_EXCEPTION", currentTime));
            }).start();
            TimeUnit.SECONDS.sleep(1); // Generate events every second
        }
    }

    private static ArrayList<AlertConfigListObject> getConfigList() {
        AlertConfigListObject alertConfig1 = new AlertConfigListObject();
        alertConfig1.client = "X";
        alertConfig1.eventType = "PAYMENT_EXCEPTION";
        AlertConfig alertConfigObj1 = new AlertConfig();
        alertConfigObj1.type = "TUMBLING_WINDOW";
        alertConfigObj1.count = 10;
        alertConfigObj1.windowSizeInSecs = 10;
        alertConfig1.alertConfig = alertConfigObj1;
        alertConfig1.dispatchStrategyList = new ArrayList<>();
        alertConfig1.dispatchStrategyList.add(new DispatchStrategyList("CONSOLE", "issue in payment", null));
        alertConfig1.dispatchStrategyList.add(new DispatchStrategyList("EMAIL", null, "payment exception threshold breached"));

        AlertConfigListObject alertConfig2 = new AlertConfigListObject();
        alertConfig2.client = "X";
        alertConfig2.eventType = "USERSERVICE_EXCEPTION";
        AlertConfig alertConfigObj2 = new AlertConfig();
        alertConfigObj2.type = "SLIDING_WINDOW";
        alertConfigObj2.count = 10;
        alertConfigObj2.windowSizeInSecs = 10;
        alertConfig2.alertConfig = alertConfigObj2;
        alertConfig2.dispatchStrategyList = new ArrayList<>();
        alertConfig2.dispatchStrategyList.add(new DispatchStrategyList("CONSOLE", "issue in user service", null));

        ArrayList<AlertConfigListObject> configList = new ArrayList<>();
        configList.add(alertConfig1);
        configList.add(alertConfig2);

        return configList;
    }

}
