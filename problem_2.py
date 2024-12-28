#  Time Complexity: O(log(n)) 
#  Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach 
# Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)

# Approach
# Even with the rotated array, one part of the array is always sorted. 
# I am checking if the left part is sorted or the right part is sorted 
# and then checking if the target is in the sorted part. 
# If it is, I am moving the left and right pointers accordingly.
# If the target is not in the sorted part, I am moving the left and right pointers accordingly.
# I am returning -1 if the target is not found.


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0 
        right = len(nums) - 1
        
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                return mid
            #  left is sorted
            elif nums[mid] >= nums[left]:
                if nums[mid] > target and target >= nums[left]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                if target > nums[mid] and target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
        return -1