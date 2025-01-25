// Overall Time Complexity : O log(n) . The n is number of elements in the search space.
// Overall Space Complexity : O(1) . The space complexity of storing the values in variables like low, high uses constant space.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No issues faced during implementation


// The solution to the problems involves identifying the pivot element and check whether the target exits on the left sorted array or the right sorted array.
// Then run the binary search algorithm on the left or right sorted array.


public class RotatedSorted {
        public int search(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
    
            while(low <= high){
                int mid = low + (high - low)/2;
                if (nums[mid] == target){
                    return mid;
                }
               
               
                else if(nums[low]<=nums[mid]){
                    if(nums[low]<=target && nums[mid]>target){
                        high = mid -1;
                    }
                    else{
                        low = mid + 1;
                    }
    
                }
                else{
                    if(nums[mid]<target && nums[high]>=target){
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
