# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :No

from typing import List

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        low = 0
        high = len(nums)-1

        while low <= high:
            mid = low +(high-low) //2
            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]:
                if nums[low] <= target < nums[mid]:
                    high =mid-1
                else:
                    low =mid+1
            elif nums[mid] <= nums[high]:
                if nums[mid]< target<= nums[high]:
                    low = mid+1
                else:
                    high = mid-1
        return -1

        