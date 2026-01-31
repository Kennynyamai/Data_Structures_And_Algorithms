package leetCodePractice;

//start at the top most right value of the matrix
//compare the value with target, if value > target, cols--
//if value < target; row++
//do this until you get to the bottom left most value of the column
//basically moving in a staircase manner
public class leetcode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int COLS = matrix[0].length;
        int ROWS = matrix.length;
        int row = 0;
        int col = COLS-1;

        //do this as until the start value gets to the bottom left corner
        //the end = matrix[ROWS-1][0]
        while(row <= ROWS-1 && col >= 0){
            if(matrix[row][col] > target){
                col--;
            }else if(matrix[row][col] < target){
                row++;
            }else{
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        leetcode240 leetcode240 = new leetcode240();
        int[][] matrix = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
        int target = 20;
        boolean ans = leetcode240.searchMatrix(matrix, target);
        System.out.println(ans);
    }
}

