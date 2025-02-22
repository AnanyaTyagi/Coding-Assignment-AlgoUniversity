package PhonePeCodingRound;

public class Test {


//    We have to find the minimum number of meeting rooms required.
//    meeting start and end time is given { { 1, 20 }, { 19, 30}, { 40, 70 } }.
    public static void main(String args[]){
        int startTimes[] = new int[1440];
        int endTimes[] = new int[1440];

        System.out.println(caculateMinimumMeetingRooms(startTimes, endTimes));

    }

    private static int caculateMinimumMeetingRooms(int[] startTimes, int[] endTimes) {


        int meetingRoomsCount = 1;
        int prevEndTime = endTimes[0];
        for(int i =1; i<startTimes.length;i++){
            if(startTimes[i]<=prevEndTime){
                prevEndTime = endTimes[i];

               // prevEndTime= Math.max(prevEndTime, endTimes[i]);
                continue;
            }
            prevEndTime = endTimes[i];
            meetingRoomsCount++;
        }
        return meetingRoomsCount;
    }
}
