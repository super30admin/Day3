// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no majorly problem faced. Difficult in figuring out the conditions


// Your code here along with comments explaining your approach in three sentences only

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0  # assigning the left pointer in the array
        right = len(nums) - 1  # assigning the left pointer in the array

        while left <= right:
            mid = (left + right) // 2 # calculating mid

            if nums[mid] == target: # if the target is equal to the mid, it returns the index of it
                return mid

            if nums[left] <= nums[mid]: # finding out if the left side of the mid is sorted
                if nums[left] <= target < nums[mid]: # then finding if the target lies between the left and the mid pointers
                    right = mid - 1

                else:
                    left = mid + 1

            else: # finding out if the right side of the mid is sorted
                if nums[mid] < target <= nums[right]:
                    left = mid + 1

                else:
                    right = mid - 1
        return -1 # returning -1 if the target is not found in the array
