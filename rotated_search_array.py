"""
Time Compexity: O(logn)
Sace Complexity: O(1)
"""


class Solution:
    def search(self, nums: list[int], target: int) -> int:
        low = 0
        high = len(nums) - 1

        while(low <= high):
            mid = (low+high) // 2

            if nums[mid] == target:
                return mid

            if nums[low] <= nums[mid]:
                if nums[mid] >= target and nums[low] <= target:
                    high = mid-1
                else:
                    low = mid+1
            else:
                if nums[mid] <= target and nums[high] >= target:
                    low = mid +1
                else:
                    high = mid - 1
        return -1