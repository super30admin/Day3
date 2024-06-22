/*
Time Complexity: 0(logn)
Space Complexity: 0(1)
Approach: Perform binary search on the rotated sorted array and search conditionally.
 */
class Solution {

    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length-1;
        int mid;

        while (low <= high){

            mid = (high-low)/2 + low;

            // System.out.println("low = "+low+ " mid = "+mid+ " high = "+high);

            if (nums[mid] == target){
                return mid;
            }

            else if (nums[mid] > target){

                if (nums[low] <= nums[mid] && target < nums[low]) {
                    // sorted array, chk target on rhs
                    low = mid + 1;
                    continue;
                }
                // target on lhs
                high = mid - 1;
            }

            else{

                if (nums[mid] <= nums[high] && target > nums[high]) {
                    // sorted array, chk target on lhs
                    // case [5,1,3] tgt=5
                    high = mid - 1;
                    continue;
                }
                // target on rhs
                low = mid + 1;
            }

        }
        return -1;
    }
}