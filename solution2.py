# Time Complexity : O(log N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low, high = 0, len(nums)-1

        while low <= high:
            mid = low + (high - low)//2 #avoid integer overflow
            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]:   #left sorted
                if nums[low] <= target and nums[mid] > target:
                    high = mid - 1
                else: 
                    low = mid + 1

            else:
                if target > nums[mid] and target <= nums[high]: # right sorted
                    low = mid + 1
                else:
                    high = mid - 1

        return -1
