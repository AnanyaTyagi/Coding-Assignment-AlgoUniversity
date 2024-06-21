package PhonePeCodingRound.Model;

public class Event {
    private String client;
    private String eventType;
    private long timestamp;

    public Event(String client, String eventType, long timestamp) {
        this.client = client;
        this.eventType = eventType;
        this.timestamp = timestamp;
    }

    public String getClient() {
        return client;
    }

    public String getEventType() {
        return eventType;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
