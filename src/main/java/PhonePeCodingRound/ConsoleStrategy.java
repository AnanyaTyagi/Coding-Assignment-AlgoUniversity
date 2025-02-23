package PhonePeCodingRound;

public class ConsoleStrategy implements DispatchStrategy {

    @Override
    public void  dispatchAlert(){
        System.out.println("[INFO] AlertingService: Dispatching to Console");
        System.out.println("[WARN] Alert: `" + "issue in payment");
    }
}
