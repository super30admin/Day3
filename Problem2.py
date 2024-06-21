## Problem2 
##Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)
## noob half baked solution, please don't waste your time assesing.
# Time Complexity : Nlog(n)
# Space Complexity : O(1) No extra space created
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : Beginner mindset


# brute force binary search


class Solution:
    def search(self, nums: List[int], target: int) -> int:

        low = 0
        high = len(nums)-1
        

        while low <= high:
            mid = low + (high - low)//2

            if nums[mid] == target:
                return mid
            elif nums[high] ==target:
                return high
            elif nums[low] ==target:
                return low
            elif (nums[mid] > target and nums[low] > target) or (nums[mid]<target and  nums[low]>target):
                low = mid + 1
            elif nums[mid]>target and  nums[low] < target:
                high = mid-1
            # elif nums[mid]<target and  nums[low]>target:
            #     low = mid+1
            elif nums[mid]<target and nums[low]<target:
                low = low+1
                high = high -1
        return -1

        