// Time complexity would be log(k) where k = m*n where m is number of rows and n is number of columns.
//  space complexity would be O(1).


class SearchInMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, columns = matrix[0].length;
        int l=0, h = (rows* columns)-1;
        int m;
        while(l<=h){
            m = l + (h-l)/2;
            int value = matrix[m/columns][m%columns];
            if( value == target){
                return true;
            }
            else if(value < target){
                l=m+1;
            }
            else{
                h = m-1;
            }
        }
        return false;
        
    }
}