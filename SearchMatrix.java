//time complexity O(logn + logm) not sure
//space compexity O(1)

class Solution {
    public boolean binarySort(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while(left <= right) {
            mid = left + (right - left)/2;
            if(target == nums[mid]) return true;
            else if(target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix[0].length;
        int n = matrix.length;
        if(m == 0 || n== 0) return false;
        int left = 0;
        int right = n-1;
        int mid;
        while(left<=right) {
            mid = left + (right - left)/2;
            if(matrix[mid][0] == target || matrix[mid][m-1]==target) return true;
            if(matrix[mid][0] < target && matrix[mid][m-1] > target) {
                return binarySort(matrix[mid], target);
            } else if(matrix[mid][0] > target) {
                right = mid - 1;
            } else if(matrix[mid][0] < target) {
                left = mid + 1;
            }
        }
        return false;
    }
}