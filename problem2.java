// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class problem2 {
    public int search(int[] nums, int target) {
        int start =0, end = nums.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target) return mid;
            
            if(nums[mid] >= nums[start]){
                if(target >= nums[start] && target < nums[mid])
                    end = mid-1;
                else 
                    start = mid+1;
            } else {
                if(target > nums[mid] && target <= nums[end])
                    start = mid+1;
                else 
                    end = mid -1;
                
            }
        }
        return -1;
    }
}