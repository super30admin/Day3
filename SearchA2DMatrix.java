//Approach : In each row, we check that if the target is <= last element only then we do a bonary search on that row otherwise we go to the next row
//Time - O(m + log n) where m is the number of rows and n is the number of columns
//Space - O(1)
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] nums, int target) {
        if(nums==null || nums.length==0) return false;

        for(int i=0; i<nums.length; i++){
            if(target > nums[i][nums[i].length-1]) continue;
            int left = 0, right = nums[0].length-1;
            while(left<=right){
                int mid = left + ((right-left)/2);
                if(nums[i][mid] == target){
                    return true;
                } else if(nums[i][mid] < target){
                    left = mid+1;
                } else{
                    right = mid-1;
                }
            }
        }

        return false;
    }
}