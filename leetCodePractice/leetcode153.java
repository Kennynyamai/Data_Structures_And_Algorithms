package leetCodePractice;

/*
LeetCode 153: Find Minimum in Rotated Sorted Array

Idea (simple):
- A rotated sorted array has a "pivot" (inflection point) where the minimum lives.
- Compare nums[mid] with nums[end]:
  - If nums[mid] > nums[end], we are on the left side of the pivot → move start right.
  - Otherwise, we are on the right side (or at the pivot) → move end left to mid.
- When start == end, that index is the minimum.
*/

public class leetcode153 {

    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        // binary search for the pivot/minimum
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[end]) {
                // mid is in the left (bigger) portion, min is to the right
                start = mid + 1;
            } else {
                // mid is in the right portion (or is the min), keep mid
                end = mid;
            }
        }

        return nums[start];
    }

    public static void main(String[] args) {
        leetcode153 leetcode153 = new leetcode153();

        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println(leetcode153.findMin(nums1)); // 1

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(leetcode153.findMin(nums2)); // 0

        int[] nums3 = {11, 13, 15, 17};
        System.out.println(leetcode153.findMin(nums3)); // 11
    }
}
