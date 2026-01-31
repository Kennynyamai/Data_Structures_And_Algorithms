package leetCodePractice;


//nums = [1,3,5,6], target = 5, ans = 2
//nums = [1,3,5,6], target = 2, ans = 1
//nums = [1,3,5,6], target = 7, ans = 4

//do binary search; if you find the answer just return the index
// if you dont find it, get the low index and add 1 to it

public class leetcode35 {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] > target) {
                end = mid -1;
            }else{
                start = mid+1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        leetcode35 leetcode35 = new leetcode35();
        int[] nums = {1,3,5,6};
        int target = 7;
        int ans = leetcode35.searchInsert(nums, target);
        System.out.println(ans);
    }
}
