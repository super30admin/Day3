# Time Complexity : O(log n)
# Space Complexity : Constant
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None


# Your code here along with comments explaining your approach 
# calculate the first, last and mid idx values and as long as the value of first is smaller than last loop through and check if the left half
# of the array from first to mid is sorted if so check if target is present using binary search if not move to the right half and repeat all the above steps recusrively.

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n_len = len(nums)

        # base case
        if n_len == 0 or nums == None:
            return -1

        low = 0
        high = n_len-1
        while low <= high:
            
            mid = (low+high)//2

            if nums[mid] == target:
                return mid
            if nums[low] <= nums[mid]:
                if target >= nums[low] and target < nums[mid]:
                    high = mid-1
                else:
                    low = mid+1
            else:
                if target > nums[mid] and target <= nums[high]:
                    low = mid+1
                else:
                    high = mid-1
        return -1
        