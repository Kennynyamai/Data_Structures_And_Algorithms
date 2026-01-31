package leetCodePractice;

import static java.lang.Math.ceil;

public class leetcode875 {

        public int minEatingSpeed(int[] piles, int h) {

            int low = 1;
            int high = 0;
            for(int pile:piles){
                high = Math.max(pile,high);
            }

            while(low<=high){
                int mid = low + (high - low)/2;
                long hoursNeeded = 0;

                for(int pile:piles){
                    hoursNeeded += (int) Math.ceil((double) pile/mid);
                    if (hoursNeeded > h) break;
                }
                //if the count is more than h, increase k
                //if the count is less than or equal to h, reduce k
                if(hoursNeeded > h){
                    low = mid + 1;
                }else{
                    high = mid-1;
                }
            }

            return low;
        }



    public static void main(String[] args) {
        leetcode875 leetcode875 = new leetcode875();
        int[] piles = {30,11,23,4,20};
        int h = 5;
        int answer = leetcode875.minEatingSpeed(piles, h);
        System.out.println(answer);
    }
    }

