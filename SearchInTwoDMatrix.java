class SearchInTwoDMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=0;
        int m = matrix.length;
        int n = matrix[0].length;
        int h = m*n -1;
        while(l<=h)
        {
            int mid = l+(h-l)/2;
            int r = mid/n;
            int c = mid%n;
            if(matrix[r][c]==target)
            return true;
            if(matrix[r][c]>target)
            h=mid-1;
            else
            l=mid+1;
        }
return false;

    }
}

//Time Complexity: O(log(m * n))
//Space Complexity: O(1)
