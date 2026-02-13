package leetCodePractice;

public class Leetcode81 {
    public boolean search(int[] nums, int target) {
        /*
         Rotated sorted array with duplicates (LeetCode 81).

         Idea (modified binary search):
         - Compute mid.
         - If nums[mid] == target → true.
         - If nums[start] == nums[mid] == nums[end], we can't tell which side is sorted,
           so shrink the search space: start++, end--.

         Otherwise:
         - If left half is sorted (nums[start] <= nums[mid]):
             - If target is within [nums[start], nums[mid]) → search left (end = mid - 1)
             - else → search right (start = mid + 1)
         - Else right half is sorted:
             - If target is within (nums[mid], nums[end]] → search right (start = mid + 1)
             - else → search left (end = mid - 1)
        */

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) return true;

            // Duplicates: cannot determine the sorted side reliably
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
                continue;
            }

            // Left half is sorted
            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Leetcode81 leetcode81 = new Leetcode81();
        int[] nums = {1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1};
        int target = 13;
        boolean answer = leetcode81.search(nums, target);
        System.out.println(answer);
    }
}
