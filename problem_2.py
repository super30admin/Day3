"""
Problem 2: Search in Rotated Sorted Array
Time Complexity: O(log n)
Space Complexity: O(1)
The code initializes two pointers, l and r, to the start and end of the list, respectively.
It then calculates the mid index and checks if the mid element is equal to the target.
If the mid element is less than the right element, it checks if the target lies between the mid and right elements.
If the target lies in this range, it updates the left pointer to mid + 1; otherwise, it updates the right pointer to mid - 1.
If the mid element is greater than the left element, it checks if the target lies between the left and mid elements.
If the target lies in this range, it updates the right pointer to mid - 1; otherwise, it updates the left pointer to mid + 1.
The code continues this process until the target element is found or the left pointer exceeds the right pointer.
"""

from typing import List


def search(nums: List[int], target: int) -> int:
    l = 0
    r = len(nums) - 1
    while l <= r:
        mid = l + (r - l) // 2
        if nums[mid] == target:
            return mid
        elif nums[mid] < nums[r]:
            if nums[mid] < target <= nums[r]:
                l = mid + 1
            else:
                r = mid - 1
        else:
            if nums[l] <= target < nums[mid]:
                r = mid - 1
            else:
                l = mid + 1
    return -1

search([4,5,6,7,0,1,2], target = 0) # Output: 4

search([4,5,6,7,0,1,2], target = 3) # Output: -1