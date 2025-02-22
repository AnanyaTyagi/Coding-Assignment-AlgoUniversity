package PhonePeCodingRound;

public class DispatchFactory {

    public DispatchStrategy getStrategy(String type){

        switch (type) {
            case "CONSOLE" : return new ConsoleStrategy();

            case "EMAIL": return new EmailStrategy();

            default: return new ConsoleStrategy();
        }
    }
}
