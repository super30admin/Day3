// This solution uses binary search on the rows to dtermine whihc row our target might fall under
// and after getting required row again binary search is applied on the  columns to check if the target is present in our 
//row or not and returns true or false based on availability
// Time Complexity: O(log m) for binary search rows and O(log n) for binary search on the row for target
//  => O(log m + log n)=> O(log(m*n))

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;
        int mid;
        int columns = matrix[low].length - 1;
        while (low != high) {
            mid = low + (high - low) / 2;
            if (target <= matrix[mid][columns]) {
                high = mid;
            } else
                low = mid + 1;
        }
        int[] reqRow = matrix[high];
        low = 0;
        high = reqRow.length - 1;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (reqRow[mid] == target)
                return true;
            if (target < reqRow[mid]) {
                high = mid;
            } else
                low = mid + 1;
        }
        boolean result = reqRow[high] == target ? true : false;
        return result;
    }
}