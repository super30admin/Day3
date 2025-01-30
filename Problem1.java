public class Problem1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int first = 0;
        int last = rows - 1;

        //find the row where target lies
        while(first <= last){
            int mid = first + (last - first)/2;

            if(matrix[mid][0] <= target && target <= matrix[mid][cols -1]){
                int left = 0;
                int right = cols - 1;

                //find the target column
                while (left <= right) {
                    int midCol = left + (right - left) / 2;

                    if (matrix[mid][midCol] == target) {
                        return true; // Found target
                    } else if (matrix[mid][midCol] < target) {
                        left = midCol + 1;
                    } else {
                        right = midCol - 1;
                    }
                }

                return false;

            }else if (target > matrix[mid][matrix[mid].length -1]) {
                first = mid + 1;
            }else{
                last = mid - 1;
            }
        }
        return false;
    }
}

/*Time Complexity -> O(lon m) + O(log n)
Space Complexity -> O(1) */

