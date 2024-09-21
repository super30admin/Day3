// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class solution{
    public int search(int[] nums, int target) {
        int low=0, high=nums.length-1;
        
        while(low<=high){
            int mid=low +(high-low)/2;
            if(nums[mid]==target) return mid;
            else if(nums[low]<=nums[mid]){ //left sorted array
                if(nums[low]<=target && nums[mid]>target){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{ // right sorted array
                if(nums[mid]<target && nums[high]>=target){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return -1;
        
    }
}
