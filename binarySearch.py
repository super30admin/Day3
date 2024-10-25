# // Time Complexity : O(log(n)) since binary search
# // Space Complexity : O(1) No aux variables
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Removed additinal case for both left sorted and right sorted arrays when one if condition is enough.

# we will implement a search operation in a rotates sorted array.
# We first find middle and then using pointer on each sides find if it is right sorted or left sorted
# at some point all pointers will land on the same value target or target range.


class Solution:
    def search(self, nums: list[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = (low + high) // 2        
            if nums[mid] == target:         
                return mid              #target is in the middle    
            elif nums[mid] < target:    #target is on the right (other condition is unncessary)
                low = mid + 1           #shift low
            else:                           
                high = mid - 1          #shift high
    
arr = [-1,0,2, 3, 4, 10, 40, 123]
x = 40

result = Solution().search(arr, x)
print(result)