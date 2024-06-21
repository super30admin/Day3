class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int low = 0;
        int high = (rows * columns)-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            int x = mid/columns;
            int y = mid%columns;
            if(matrix[x][y] == target) return true;
            if(matrix[x][y]>target){
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return false;
    }

      public static void main(String[] args) {
        Search2DMatrix obj = new Search2DMatrix();
        int[][] nums = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(obj.searchMatrix(nums, 3));
    }
}