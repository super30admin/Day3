# // Time Complexity : O(log(n) 
# // Space Complexity : O (1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : NA

# # // Your code here along with comments explaining your approach in three sentences only
# - we observed that either the left or the right side of the array will always be sorted
# - so, we check if left is sorted, then the next check is if the target lies on the left side, if target does not lie on left side, it must be on the right
# - if left is not sorted we know that right is sorted, if the target does nt lie on the right side, then it must be on the left side
# - if we find the element at mid, we return mid, else -1

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if (nums is None or len(nums) == 0):
            return -1
        
        n = len(nums)
        low = 0
        high = n - 1
       
        while(low <= high):
            mid = low + (high - low) / 2 # prevent integer overflow
            # if the target is found at mid, we return mid
            if nums[mid] == target:
                return mid
            
            # check if left side is sorted
            if nums[low] <= nums[mid]:
                # check if the target can exist on this side
                # already compared with mid
                if target >= nums[low] and target < nums[mid]:
                    # left is sorted and target exists on left side
                    high = mid - 1
                else:
                    # left is sorted and target exists on right
                    low = mid + 1

            # left is not sorted, so right should be sorted
            else:
                if target > nums[mid] and target <= nums[high]:
                    # target exists on the sorted right side
                    low = mid + 1
                else:
                    high = mid - 1
                        

        return -1




        