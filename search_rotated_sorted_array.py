# Time Complexity : O(logN)
#Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Approach:
# Used the binary search (modified). Since the array is sorted at any point if we start from the middle point, one side of the 
# array will be sorted. So we can check if left side is sorted and element lies between that range of values, we move left
# same logic for the right side
# if we reach the end of loop then the element was not found and we can return -1
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1
        while (left <= right):
            mid = left + int((right - left) / 2)
            if (nums[mid] == target):
                return mid
            elif (nums[left] <= nums[mid]):
                if (target >= nums[left] and target <= nums[mid]):
                    right = mid
                else:
                    left = mid + 1
            else:
                if (target >= nums[mid] and target <= nums[right]):
                    left = mid
                else:
                    right = mid - 1
        return -1
        