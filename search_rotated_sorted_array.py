from typing import List
#Time complexity: O(logn) because search space is eliminated by half in each iteration
#Space complexity : O(1)
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low, high = 0, len(nums)-1
        while low <= high:
            mid = (low + high)//2
            if nums[mid] == target:
                return mid
            if nums[low] <= nums[mid]:# left sorted
            # check if target lies in the range
                if nums[low] <= target  and nums[mid] > target:
                    high = mid-1
                else:
                    low = mid+1
            else: # right sorted
                if nums[mid] <target and nums[high] >= target:
                    low = mid+1
                else:
                    high = mid-1
        return -1



s = Solution()
matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
target = 10
print(s.search(matrix, target))

        