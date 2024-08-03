class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low, high = 0, len(nums) - 1
        mid = low + ((high - low) // 2)

        while (low <= high):
            mid = low + ((high - low) // 2)

            if nums[mid] == target:
                return mid

            # complete sorted
            # This is redundant part though
            if nums[low] <= nums[mid]:

                if target >= nums[low] and target < nums[mid]:

                    high = mid - 1

                else:
                    low = mid + 1

            # right sorted
            elif nums[mid] < nums[high]:

                if target > nums[mid] and target <= nums[high]:

                    low = mid + 1

                else:
                    high = mid - 1

        if nums[mid] == target:
            return mid

        return -1
