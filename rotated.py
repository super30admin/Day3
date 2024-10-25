# The code defines a search method to find a target value in a rotated sorted array using binary search.
# The array is sorted but rotated, meaning it was initially sorted and then rotated at some pivot unknown to us.
# Two pointers, 'l' and 'r', are used to represent the left and right boundaries of the current search space.
# 
# In each iteration:
#   - The mid-point (mid) is calculated to divide the array in half.
#   - If nums[mid] equals the target, mid is returned as the index where the target is found.
#   - If the left half (from nums[l] to nums[mid]) is sorted:
#       - If the target lies within this sorted half (target >= nums[l] and target < nums[mid]), we narrow the search to this half by setting r = mid - 1.
#       - Otherwise, we search the right half by setting l = mid + 1.
#   - If the right half (from nums[mid] to nums[r]) is sorted:
#       - If the target lies within this sorted half (target > nums[mid] and target <= nums[r]), we search this half by setting l = mid + 1.
#       - Otherwise, we narrow the search to the left half by setting r = mid - 1.
# If the target is not found after the loop, -1 is returned, indicating it is not present in the array.
# 
# TC: O(log n) - Binary search halves the search space each iteration.
# SC: O(1) - Constant space usage, as only pointers for the search range and mid-point are maintained.


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums) - 1

        while l <= r:
            mid = (l + r) // 2
            if target == nums[mid]:
                return mid

            if nums[l] <= nums[mid]:
                if target > nums[mid] or target < nums[l]:
                    l = mid + 1
                else:
                    r = mid - 1
                    
            else:
                if target < nums[mid] or target > nums[r]:
                    r = mid - 1
                else:
                    l = mid + 1
        return -1
