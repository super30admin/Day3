// Time Complexity :O(logN)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes


public class SearchrotatedArray{
    public int search(int[] nums, int target) {
        int n=nums.length;
        if(n==0 || nums==null)
        return -1;
    
    int low=0;
    int high=n-1;

    while(low<=high){
        int mid=low+(high-low)/2;// in order tosave int overflow
        if(nums[mid]==target){
            return mid;
        }else if (nums[low]<=nums[mid]){
            //left sorted 
            if(nums[low]<=target && target<nums[mid]){
                high=mid-1;

            }else{
                low=mid+1;
            }
        }else{
            if(nums[mid]<target && target<=nums[high]){
                low=mid+1;

            }else{
                high=mid-1;
            }
        }

        }
return -1;
    }
}

