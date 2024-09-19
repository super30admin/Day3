'''
    Time Complexity: O(logn)
    Space Complexity: O(1)
    Ran successfully on leetcode
    Difficulty: Was able to understand, but took some time to build the final logic
'''

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low, high = 0, len(nums) - 1

        while low <= high:
            mid = (low + high) // 2

            if target == nums[mid]:
                return mid

            if nums[low] <= nums[mid]:
                if target > nums[mid] or target < nums[low]:
                    low = mid + 1
                else:
                    high = mid - 1 
            else:
                if target < nums[mid] or target > nums[high]:
                    high = mid - 1
                else:
                    low = mid + 1

        return -1
        