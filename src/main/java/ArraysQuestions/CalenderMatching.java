package ArraysQuestions;
import java.util.*;

public class CalenderMatching {


        public static List<StringMeeting> calendarMatching(
                List<StringMeeting> calendar1,
                StringMeeting dailyBounds1,
                List<StringMeeting> calendar2,
                StringMeeting dailyBounds2,
                int meetingDuration
        ) {
            ArrayList<StringMeeting> blocked = new ArrayList<>();

            // Add all meetings from the first calendar
            blocked.addAll(calendar1);

            // Add daily boundaries
            blocked.add(new StringMeeting(0, dailyBounds1.start()));
            blocked.add(new StringMeeting(dailyBounds1.end(), 60 * 24));

            // Add all meetings from the second calendar
            blocked.addAll(calendar2);

            // Add daily boundaries for the second calendar
            blocked.add(new StringMeeting(0, dailyBounds2.start()));
            blocked.add(new StringMeeting(dailyBounds2.end(), 60 * 24));

            // Sort meetings by start time
            Collections.sort(blocked, Comparator.comparing(StringMeeting::start));

            int possibleStart = 0; // Start looking from the very beginning of the day
            ArrayList<StringMeeting> free = new ArrayList<>();

            for (StringMeeting m : blocked) {
                // If the current meeting ends before the possible start, continue
                if (m.end() <= possibleStart) {
                    continue;
                }

                // If there is a gap between the current meeting and the possible start
                if (m.start() > possibleStart) {
                    int length = m.start() - possibleStart;

                    // Check if the gap is large enough for the meeting
                    if (length >= meetingDuration) {
                        free.add(new StringMeeting(possibleStart, m.start()));
                    }
                }
                // Update the start to the end of the current meeting
                possibleStart = m.end();
            }

            return free;
        }

        static class StringMeeting {
            public String start;
            public String end;

            public StringMeeting(String start, String end) {
                this.start = start;
                this.end = end;
            }

            public StringMeeting(int start, int end) {
                this(minutesToString(start), minutesToString(end));
            }

            int start() {
                return stringToMinutes(start);
            }

            int end() {
                return stringToMinutes(end);
            }

            private static String minutesToString(int minutes) {
                int hours = minutes / 60;
                int mins = minutes % 60;
                return hours + ":" + (mins < 10 ? "0" : "") + mins; // Remove leading zero from hours
            }

            private static int stringToMinutes(String string) {
                String[] parts = string.split(":");
                return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
            }
        }
    }

