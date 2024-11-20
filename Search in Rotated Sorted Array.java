//tc - logn

class Solution {
    public int search(int[] nums, int target) {
      
      int low = 0;
      int mid;
      int high = nums.length - 1;
      while(low <= high){
          mid = low + (high-low)/2;//to keep the value in interger range or to avoid integer overflow
          if(nums[mid] == target){ 
            return mid;
          }else if(nums[low] <= nums[mid]){//checking for left sorted array
          
            if(target >= nums[low] && target <nums[mid]){
                high = mid - 1;
            }else{
                low = mid+1;
            }
          }else{//it is right sorted array
             
             if(target > nums[mid] && target <= nums[high])
             {
                low = mid + 1;
             }else{
                high = mid - 1;
             }

      }
      }

      return -1;
    }
}