# Binary-Search-1
## Problem2 : Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)

# Time Complexity : O(log n) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Approach
# set low = 0 and high to len(arr)-1. get the middle element. Check whether is the list is a left sorted or right sorted list
# If value of low <= value of mid, it means it is a left sorted array. Check if the target lies between value of low and mid. If yes, set high to mid -1 else set low to mid + 1
# Similary for right sorted array, check if the target is between mid and high, if yes set low = mid + 1 else high = mid -1

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums)-1
        while l <= r:
            mid = l + (r-l)//2
            if target == nums[mid]:
                return mid
            

            else:
                if nums[l] <= nums[mid] :
                    if nums[l] <= target < nums[mid]:
                        r = mid-1
                    else:
                        l = mid+1
                
                else:
                    if nums[mid] < target <= nums[r]:
                        l = mid+1
                    else:
                        r = mid-1
        return -1