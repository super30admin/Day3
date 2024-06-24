/*
Time Complexity --> O(logn)
Space Complexity --> O(1)
 */

class Solution {

    public int search(int[] nums, int target) {
        int n = nums.length - 1;
        int f = 0;
        int l = n;
        int mid;
        while (f <= l) {
            mid = (f + l) / 2;
            System.out.print("MID is " + nums[mid]);
            System.out.print("FIRST is " + nums[f]);
            System.out.println("LAST is " + nums[l]);

            if (target == nums[mid]) {
                return mid;
            }
            //check if left is sorted
            if (nums[f] <= nums[mid]) {
                //check if this is the range
                if (target >= nums[f] && target < nums[mid]) {
                    //move left
                    l = mid - 1;
                } else {
                    f = mid + 1;
                }

            }//if
            //check if right is sorted
            if (nums[l] > nums[mid]) {
                //check if in this range
                if (target <= nums[l] && target > nums[mid]) {
                    f = mid + 1;
                } else {
                    l = mid - 1;
                }
            }

        }//while

        return -1;

    }//method
}//class
