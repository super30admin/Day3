from typing import List
"""
    Leetcode #33 Search in rotated sorted array
    https://leetcode.com/problems/search-in-rotated-sorted-array/description/

    """

"""
Brute Force Approach: 
Search for elements linerly
Time Complexity: O(N)
Space Complexity: O(1) constant
"""


class Solution:
    def searchBruteForce(self, nums: List[int], target: int) -> int:
        # edge case
        if not nums:
            return -1

        for i, num in enumerate(nums):
            if target == num:
                return i

        # outside for loop
        return -1

    # Optimized solution
    """
    Brute Force Approach: 
    One of the two side is always sorted. Now in the sorted side, 
    we can determine if elemnt is present
    or not and depending on that we can disacrd the side in binary serach fashion.
    Algorithem:
    step 1: first check which side is sorted
    step 2: if elemnt is present in sorted side move their otherwise opposite
    At least one of the side will always be sorted at any step.
    Time Complexity: O(logN)
    Space Complexity: O(1) constant
    """

    def binarySearchIterative(self, nums: List[int], target: int) -> int:
        # calculate low and high
        low = 0
        high = len(nums) - 1

        while low <= high:
            # calculate mid
            mid = low + (high - low) // 2

            if nums[mid] == target:
                return mid

            if nums[low] <= nums[mid]:
                # left part is sorted
                if nums[low] <= target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                # right part is sorted
                if nums[mid] < target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1

        # outside while loop
        return -1

    def recursiveBinarySearch(self, nums: List[int], target: int, low: int, high: int) -> int:

        # stopping condition
        if low > high:
            return -1

        mid = low + (high - low) // 2

        if nums[mid] == target:
            return mid

        # check if left part is sorted
        if nums[low] <= nums[mid]:
            # left part sorted
            if nums[low] <= target < nums[mid]:
                # target lies this side
                high = mid - 1
                return self.recursiveBinarySearch(nums, target, low, high)
            else:
                # target lies in righ side
                low = mid + 1
                return self.recursiveBinarySearch(nums, target, low, high)
        else:
            # right part is sorted
            # check if target is present in right part
            if nums[mid] < target <= nums[high]:
                # move serach spae to right
                low = mid + 1
                return self.recursiveBinarySearch(nums, target, low, high)
            else:
                high = mid - 1
                return self.recursiveBinarySearch(nums, target, low, high)

    def search(self, nums: List[int], target: int) -> int:
        # edge case
        if not nums:
            return -1
        low = 0
        high = len(nums) - 1
        return self.recursiveBinarySearch(nums, target, low, high)
