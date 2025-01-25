# Time complexity: O(log n)
# Space complexity: O(n)
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        numlen = len(nums)
        index = -1
        if numlen == 0:
            return index
        low = 0
        high = numlen-1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                index = mid
                break
            if nums[low] <= nums[mid]:
                #sorted
                if nums[low] <= target and target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            elif nums[high] >= nums[mid]:
                #sorted
                if nums[mid] < target and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid -1
        return index