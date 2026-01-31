package leetCodePractice;

public class leetcode69 {
    public int mySqrt(int x) {
        int right = x/2;
        int left = 1;
        //the plan is to find the minimum number that when you multiply itself two times it gives you less than or equal to but not greater than x
        //lets say x = 8; right = 4; mid =2
        int result = 0;

        while(left <= right){
            int mid = left + (right-left)/2;
            if((mid*mid) <= x){
                result = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return result;
    }

    public static void main(String[] args){
        leetcode69 leetcode69 = new leetcode69();
        int x = 8;
        int ans = leetcode69.mySqrt(x);
        System.out.println(ans);
    }
}
