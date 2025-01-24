"""
Search in Rotated sorted array

Brute force approach -- Linear search - TC - O(n) SC - O(1)

Binary Search Approach --
TC - O(log n)
SC - O(1)
"""

nums = [4, 5, 6, 7, 0, 1, 2]
target = 0


class Solution:
    def search(self, nums, target):
        if nums is None or len(nums) == 0 or target is None: return -1

        n = len(nums)

        low = 0
        high = n - 1

        while low <= high:
            mid = low + (high - low) // 2

            if nums[mid] == target: return mid

            # check which part is sorted
            # left is sorted
            if nums[low] <= nums[mid]:
                # check if target is present
                if nums[low] <= target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                # right is sorted
                if nums[mid] <= target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1


obj = Solution()
print(obj.search(nums, target))
