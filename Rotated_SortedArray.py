# Time Complexity : O(log n), where n is the length of the input array
# Space Complexity : O(1), as no extra space is used apart from a few variables
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
from typing import List

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1  # Initialize binary search boundaries

        while left <= right:
            mid = (left + right) // 2  # Find the middle index

            # If the middle element is the target, return its index
            if nums[mid] == target:
                return mid

            # Determine which part of the array is sorted
            if nums[left] <= nums[mid]:  # Left part is sorted
                if nums[left] <= target < nums[mid]:  # Target is in the left part
                    right = mid - 1
                else:  # Target is in the right part
                    left = mid + 1
            else:  # Right part is sorted
                if nums[mid] < target <= nums[right]:  # Target is in the right part
                    left = mid + 1
                else:  # Target is in the left part
                    right = mid - 1

        # If the target is not found, return -1
        return -1
