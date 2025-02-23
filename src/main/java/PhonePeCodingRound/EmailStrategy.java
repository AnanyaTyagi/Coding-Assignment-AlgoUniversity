package PhonePeCodingRound;

public class EmailStrategy implements DispatchStrategy {

    @Override
    public void  dispatchAlert(){
        System.out.println("[INFO] AlertingService: Dispatching an Email");
        System.out.println("[INFO] Email Subject: `" +  "payment exception threshold breached");
    }

}
