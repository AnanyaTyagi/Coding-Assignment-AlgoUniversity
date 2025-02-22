package ArraysQuestions;

public class LongestPeak {

    public static int longestPeak(int[] array) {
        int longestPeak = 0;

        // Iterate through the array starting from the second element and stopping at the second to last
        for (int i = 1; i < array.length - 1; i++) {
            // Check if we found a peak: the current element is greater than both its neighbors
            if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
                int left = i - 1;
                int right = i + 1;

                // Expand to the left as long as elements are still increasing
                while (left >= 0 && array[left] < array[left + 1]) {
                    left--;
                }

                // Expand to the right as long as elements are still decreasing
                while (right < array.length && array[right] < array[right - 1]) {
                    right++;
                }

                // Calculate the peak length
                int peakLength = right - left - 1;
                longestPeak = Math.max(longestPeak, peakLength);
            }
        }

        return longestPeak;
    }
}
