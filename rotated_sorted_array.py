from typing import List


class Solution:
    def linear_search(self, nums: List[int], target: int) -> int:
        """
        This method search for the target using linear search.
        Edge Case: target may or may not be found, array is empty, number of elements in the array is 1
        :param nums: array of integers that is search space
        :param target: integer to find
        :return: index of target if found else -1
        Takes O(n) time since whole array is traversed.
        """
        for idx, num in enumerate(nums):
            if num == target:
                return idx

        return -1

    def search(self, nums: List[int], target: int) -> int:
        """
        This method search for the target using binary search.
        The idea is: (1) wherever mid lands one portion (left or right) of the array will always be sorted.
        (2) Identify which half of the array is sorted
        (3) Since sorted array gives a range we can check if the target lies in the range.
        (4) update lo and hi accordingly
        :param nums: array of integers that is search space
        :param target:integer to search
        :return:index of target if found else -1
        """
        lo = 0
        hi = len(nums) - 1
        while lo <= hi:
            mid = lo + (hi - lo) // 2
            if target == nums[mid]:
                return mid

            elif nums[mid] < nums[hi]:  # left sorted
                if target > nums[mid] >= target:
                    lo = mid + 1
                else:
                    hi = mid - 1

            else:  # right sorted
                if nums[lo] <= target < nums[mid]:
                    hi = mid - 1
                else:
                    lo = mid + 1


obj = Solution()
print(obj.search([4, 5, 6, 7, 0, 1, 1, 2], 4))
