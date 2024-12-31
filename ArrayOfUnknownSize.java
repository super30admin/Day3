/* Description: Here, the array size is unknown but we have been given that any index out of bound will return 
infinity, so using this clue, starting by calculating the higher bound(by comparing the target with array[high]
and multiplying high by 2 till target is > array[higher]) and then performing binary search.
 */
// Time Complexity : O(log n) - performing binary search
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Not having premium so tried to write and run full code on local. Works
// Any problem you faced while coding this : No

interface ArrayReader {
    public int get(int index);
}

class Solution {
    public int search(ArrayReader reader, int target) {
        // Setting the low to 0 and high to 1 initially
        int low = 0;
        int high = 1;
        // Till the target is > value at high
        while (reader.get(high) < target) {
            // replace low by high+1
            low = high + 1;
            // Multiplying high by 2 because, in BS we divide by 2 in every search, so to
            // set the lower and upper bounds, multiplying by 2
            high = high * 2;
        }
        // Check if equal, return high (target is at index high)
        if (reader.get(high) == target) {
            return high;
        }
        // If not, perform the binary search
        // When low is less than or equal to high, come out of the loop
        while (low <= high) {
            // Calculate the mid in below way to avoid integer overflow exception
            int mid = low + (high - low) / 2;
            // Check if the mid itself is target by comparing
            if (reader.get(mid) == target) {
                return mid;
            }
            // Else check if midValue > target, move to left
            else if (reader.get(mid) > target) {
                high = mid - 1;
            } else {
                // Else move to right
                low = mid + 1;
            }
        }
        // If not found, return -1
        return -1;
    }

    public static void main(String[] args) {
        ArrayReader reader = new ArrayReader() {
            public int get(int index) {
                int[] nums = new int[] { 1, 2, 3, 4, 5, 9 };
                int n = nums.length;
                if (index < n) {
                    return nums[index];
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        };
        Solution s = new Solution();
        System.out.println(s.search(reader, 14));
    }
};
