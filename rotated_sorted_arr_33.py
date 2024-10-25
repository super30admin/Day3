# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def search(self, nums: List[int], target: int) -> int:

        l, r = 0, len(nums) - 1

        while l <= r:
            mid = l + (r - l) // 2

            if nums[mid] == target:
                return mid

            if nums[l] <= nums[mid]:  # check left sorted?
                if nums[l] <= target and nums[mid] > target:
                    r = mid - 1
                else:
                    l = mid + 1
            else:  # right is sorted

                if nums[mid] < target and nums[r] >= target:
                    l = mid + 1
                else:
                    r = mid - 1
        return -1


