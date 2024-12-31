
// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


//the logic here is that after finding mid, one of the either side will be sorted and we
//need to check if the target lies btw that sorted side if yes move to that side or other.
    class SearchInsideRotatedSortedArray {
        public int search(int[] nums, int target) {
            if(nums == null || nums.length == 0){
                return -1;
            }
            int low = 0;
            int high = nums.length-1;

            while(low <= high){
                int mid  =  low + (high-low)/2;

                if(nums[mid] == target){
                    return mid;
                }
                if(nums[low] <= nums[mid]){
                    //check if the target lies between the sorted side.
                    if(nums[low] <= target && target < nums[mid]){
                        high = mid - 1;
                    }
                    else{
                        low = mid + 1;
                    }
                }
                else{
                    if(nums[mid] < target && target <= nums[high]){
                        low = mid + 1;
                    }
                    else{
                        high = mid - 1;
                    }
                }
            }
            return -1;
        }
    }