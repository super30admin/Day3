class ArraySearch2D {
    public boolean searchMatrix(int[][] matrix, int target) {

        //TC - O(log m*n), SC - O(1)
        //using binary search

        //base condition check
        if(matrix == null && matrix.length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;
        int low =0;
        int high = m*n -1;

        while(low <= high) {
            //calculate the mid
            int mid = low + (high-low)/2; //To handle integer overflow

            //check where mid belongs in 2D array
            int mid_val = matrix[mid/n][mid%n];

            if(mid_val == target)
                return true;

            if(mid_val > target)
                high = mid -1;
            else
                low = mid+1;
        }

        return false;
    }

}