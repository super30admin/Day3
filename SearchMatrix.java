//time complexity O(log(mn))
//space compexity O(1)
//Did this code successfully run on Leetcode : yes

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        int m = matrix.length;
        System.out.println(n + " size " + m);
        int low = 0;
        int high = m*n - 1;

        while(low <= high) {
            int mid = low + (high - low)/2;
            int row = mid/n;
            int col = mid%n;
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
