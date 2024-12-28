// 33. Search in Rotated Sorted Array

// TC: O(log(n))
// SC: O(1)
// Solved in LC: Yes

// Approach 1
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int n = nums.length;
        int l = 0, h = n - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target < nums[mid])
                    h = mid - 1;
                else
                    l = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[h])
                    l = mid + 1;
                else
                    h = mid - 1;
            }
        }
        return -1;
    }
}


// Approach 2
class Solution2 {
    public int binarySearch(int[] nums, int target, int l, int h) {
        while (l <= h) {
            int mid = (l + h) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                h = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int len = nums.length;
        int l = 0, h = len - 1;
        int ref = nums[0];
        while (l <= h) {
            int mid = (l + h) / 2;
            if (nums[mid] < ref)
                h = mid - 1;
            else
                l = mid + 1;
        }
        System.out.println(l + " " + h);
        int left = binarySearch(nums, target, 0, h);
        if (left >= 0)
            return left;
        return binarySearch(nums, target, l, len - 1);
    }
}