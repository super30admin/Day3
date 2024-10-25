# // Time Complexity : O(log(n)) since binary search
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : No
# // Any problem you faced while coding this : Fails half the time

# we will implement a search operation in a rotates sorted array.
# We first find middle and then using pointer on each sides find if it is right sorted or left sorted
# at some point all pointers will land on the same value target or target range.


class Solution:
    def search(self, nums: list[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2               
        
            if mid == target:                                   #target is in the middle
                return mid
            elif nums[low] <= nums[mid]:                        # left sorted
                if nums[low] <= target and nums[mid] > target:  # target is in left
                    high = mid - 1
                else:
                    low = mid + 1
            else:                                               # right sorted
                if nums[mid] < target and nums[high] >=target:  # target is in right
                    low = mid + 1
                else:
                    high = mid - 1
        return -1
    
arr = [100,224,2, 3, 4, 10, 40]
x = 100

result = Solution().search(arr, x)
print(result)