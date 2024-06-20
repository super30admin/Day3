class Solution {
    //Binary Search utility method 
    private boolean binarySearch(int [] arr, int target){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid]==target) return true;
            if(arr[mid]>target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        //initializing matrix left and right as mLeft and mRight
        int mLeft = 0; 
        int mRight = matrix.length - 1;
        while(mLeft<=mRight){
            int mid = mLeft + (mRight - mLeft)/2;
            //mid array length
            int midArrayLength = matrix[mid].length;
            //Check if the first or last element of mid index is equal to target
            if(matrix[mid][0] == target || matrix[mid][midArrayLength-1] == target) return true;
            // Check if target exist in between first and last index if yes perform binary search
            if(matrix[mid][0]<target && matrix[mid][midArrayLength-1]>target){
                return this.binarySearch(matrix[mid], target);
            }else if(matrix[mid][0]>target){
                mRight = mid - 1;
            }else{
                mLeft = mid + 1;
            }
        }
        return false;
    }

}