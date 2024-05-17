"""
Binary-Search-1
Problem2
Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)

Time Complexity : O(logn)
Space Complexity :  O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
We'll apply binary search to find the target but instead of directly checking whether target is < nums[mid] and moving towards left here we'll first check whether left part 
is sorted and if left part is sorted then we check whether target lies inbetween low and mid and if it does then we're moving high to mid - 1 else we'll move left to mid + 1. If left part is not sorted
then we check if right part is sorted by checking whether target lies inbetween mid and high and if it does then we move low to mid + 1 else we move high to mid - 1.
"""

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums) == 0:
            return -1
        
        low, high = 0, len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]:
                if target >= nums[low] and target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if target > nums[mid] and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1

        return -1
