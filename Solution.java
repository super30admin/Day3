class Solution {
    public boolean searchMatrix(int[][] matrix, int target)
    {
        if(matrix.length==0 || matrix==null)
        {
            return false;
        }
        int rows=matrix.length;       //3
        int column= matrix[0].length;    //4
        int low=0;
        int high= rows*column-1;
        while(low<=high)
        {
            int mid= low+(high-low)/2; // 11/2 =5
            int row=mid/column;            //5/4= 1
            int col=mid % column;           // 5%4= 1
            if(matrix[row][col]== target)
            {
                return true;
            }
            else if(target> matrix[row][col])
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] []matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(solution.searchMatrix(matrix, 8));
    }
}