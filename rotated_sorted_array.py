# time complexity O(log n)
# space complexity O(1)
# tested on leetcode
# Using binary search to check if the left side is sorted or the right is sorted
# pick the sorted side and check if target falls on that side
# move high and low pointers accordingly

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1 
        while (low <= high):
            mid = low + (high - low) // 2
            if nums[mid] == target:
                return mid
            if nums[low] <= nums[mid]: # check if left side is sorted
                if nums[low] <= target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if nums[mid] < target <= nums[high]: # check if target is on right side
                    low = mid + 1
                else:
                    high = mid - 1
        return -1

