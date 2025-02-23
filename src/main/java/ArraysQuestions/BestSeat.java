package ArraysQuestions;

public class BestSeat {
         // public int bestSeat(int[] seats) {
        //   int result = -1;
        //   int maxLength = Integer.MIN_VALUE;
        //   int length = 0;
        //   int startIndex = 0;
        //   int endIndex = 0;
        //   int maxStartIndex = 0;
        //   int maxEndIndex = 0;
        //   boolean zeroSubArray = false;
        //   boolean allSeatsFilled = true;
        //   for(int i = 0; i < seats.length;i++){
        //     if(seats[i]==0){
        //       allSeatsFilled = false;
        //     }
        //     if(!zeroSubArray && seats[i]==0){
        //         zeroSubArray = true;
        //         startIndex = i;
        //         length++;
        //      }
        //     if(!zeroSubArray && seats[i]==1){
        //        continue;
        //      }
        //     if(zeroSubArray && seats[i]==0){
        //        length++;
        //      }
        //       if(zeroSubArray && seats[i]==1){
        //        endIndex = i;

        //        if(length > maxLength){
        //           maxLength = length;
        //           maxStartIndex = startIndex;
        //           maxEndIndex = endIndex;
        //        }
        //       zeroSubArray = false;
        //      }
        //   }
        //   if(allSeatsFilled){
        //     return -1;
        //   }

        //   result = (maxStartIndex - endIndex-1)/2;
        //   return result;
        // }

        public int bestSeat(int[] seats) {
            int maxLength = 0; // Max length of empty seats
            int startIndex = 0; // Starting index of the best segment
            int maxStartIndex = -1; // Best segment start index
            int endIndex; // End index not directly needed

            for (int i = 0; i < seats.length; i++) {
                if (seats[i] == 0) { // Found an empty seat
                    startIndex = i; // Potential start of a segment
                    int length = 0;

                    // Count the length of the segment of empty seats
                    while (i < seats.length && seats[i] == 0) {
                        length++;
                        i++;
                    }
                    if (length > maxLength) { // Update if this is the longest segment
                        maxLength = length;
                        maxStartIndex = startIndex; // Update the best start index
                    }
                }
            }

            // If there are no empty seats
            if (maxLength == 0) {
                return -1;
            }

            // Return the best seat in the largest segment
            if (maxLength % 2 == 0) {
                return maxStartIndex + (maxLength / 2) - 1; // Lower middle
            } else {
                return maxStartIndex + (maxLength / 2); // Exact middle
            }  // Return the middle seat
        }
}
