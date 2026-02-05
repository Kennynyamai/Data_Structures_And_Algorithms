package leetCodePractice;

public class Leetcode1011 {

    public int shipWithinDays(int[] weights, int days) {
        int low = 0;   // min capacity (must be at least max weight)
        int high = 0;  // max capacity (sum of all weights)

        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }

        int answer = high;

        while (low <= high) {
            int mid = low + (high - low) / 2; // candidate capacity

            int daysNeeded = 1;
            int currLoad = 0;

            for (int w : weights) {
                if (currLoad + w <= mid) {
                    currLoad += w;
                } else {
                    daysNeeded++;
                    currLoad = w;
                }
            }

            if (daysNeeded > days) {
                low = mid + 1;      // capacity too small
            } else {
                answer = mid;       // capacity works, try smaller
                high = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Leetcode1011 sol = new Leetcode1011();

        int[] weights1 = {1,2,3,4,5,6,7,8,9,10};
        int days1 = 5;
        System.out.println("Answer 1: " + sol.shipWithinDays(weights1, days1)); // expected 15

        int[] weights2 = {3,2,2,4,1,4};
        int days2 = 3;
        System.out.println("Answer 2: " + sol.shipWithinDays(weights2, days2)); // expected 6

        int[] weights3 = {1,2,3,1,1};
        int days3 = 4;
        System.out.println("Answer 3: " + sol.shipWithinDays(weights3, days3)); // expected 3
    }
}
