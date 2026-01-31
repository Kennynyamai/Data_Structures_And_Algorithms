public class leetcode33 {

    public static void main(String[] args) {
        //nums = [4,5,6,7,0,1,2], target = 0 output = 4
        //first find the peak
        //look for the target in 0 to peak-1
        //and also from peak + 1 to end

        // you have to find peak using binary search and what are the conditions
        // it means mid-1 > mid
        //if that's not the case then you need to determine anre you in ascenidning side or desceniding side
        //to check ascending, mid > end; in that case; start = mid + 1
        //to check descending, mid < start; in that case end = mid - 1

        int[] nums = {4,5,6,7,0,1,2};
        int peak = findPeak(nums);
        System.out.println(peak);
    }

    public static int findPeak(int[] nums){
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end-start)/2;
            if(mid > 0 && nums[mid-1] > nums[mid]){
                return mid-1;
            }
            //check for ascending
            if(nums[mid] > nums[end]) start = mid + 1;
            //check for descending
            if(nums[mid] < nums[start]) end = mid -1;
        }

        return -1;
    }

}