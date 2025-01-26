# Time Complexity : O(log)
# Space Complexity : O(1)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

"""
In a rotated sorted array, at least one side of the array would be sorted.
I am using binary search to discard one side of the array as follows:
1. Firstly if nums[mid] == target, then mid is the correct index
2. If left side is sorted check if the target is on the left side,
   If yes, discard the right side, else discard the left side
3. If right side is sorted, check if the target is on the right side,
   If yes, discard the left side, else discard the right side
"""

def search(nums, target):
    n = len(nums)
    low = 0
    high = n - 1


    while low <= high:
        mid = low + (high-low)//2
        if nums[mid] == target:
            return mid
        # left side is sorted
        elif nums[low] <= nums[mid]:
            # check if target is on the left side
            if nums[low] <= target < nums[mid]:
                # discard the right side
                high = mid - 1
            else:
                # discard the left side
                low = mid + 1
        # right side is sorted
        else:
            # check if target is on the right side
            if nums[mid] < target <= nums[high]:
                # discard the left side
                low = mid + 1
            else:
                # discard the right side
                high = mid - 1

    return -1

