# Time Complexity : 0(logn)
# Space Complexity : 0(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums) - 1
        if nums is None:
            return -1
        low = 0
        high = n
        while low <= high:
            mid = low + ((high - low)//2)
            if nums[mid] == target:
                return mid
            if nums[low] <= nums[mid]:
                if target >= nums[low] and target < nums[mid]:
                    high = mid -1
                else:
                    low = mid +1
            else:
                if target > nums[mid] and target <= nums[high]:
                    low = mid +1
                else:
                    high = mid -1
        return -1 



        

