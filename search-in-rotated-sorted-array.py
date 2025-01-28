# This code performs a binary search on a rotated sorted array to find the target. 
# It identifies the sorted half in each iteration and adjusts the search range accordingly.
# Time Complexity:O(logn) — Halves the search range in each step.
# Space Complexity: O(1) — Uses constant extra space.
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target:
                return mid
            if nums[low] <= nums[mid]:
                if nums[low] <= target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1

            else:
                if nums[mid] <= target < nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1