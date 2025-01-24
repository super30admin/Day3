# Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)

# Time Complexity: O(log(n))
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach:
# Use binary search to find the target in a rotated sorted array.
# Adjust the search range based on comparisons to determine which half contains the target.
# Continue narrowing down the search until the target is found or the range is exhausted.

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        if(n == 0):
            return -1

        low,high = 0, n-1
        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]:
                if nums[low] <= target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if nums[mid] < target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1