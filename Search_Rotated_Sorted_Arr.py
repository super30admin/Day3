# Time complexity: O(logn)
# Space complexity: O(1)
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums)-1
        
        while left <= right:
            mid = (right+left)//2
            if target == nums[mid]:
                return mid
            #check left sorted
            elif nums[mid] >= nums[left]:
                if nums[left] <= target and target < nums[mid]:
                    right = mid-1
                else:
                    left = mid+1
            # check right sorted
            else:
                if nums[mid] < target and target <= nums[right]:
                    left = mid+1
                else:
                    right = mid-1

        return -1
            