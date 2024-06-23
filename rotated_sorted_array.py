"""
TC - O(logN)
SC - O(N)
Approach:

Set low. high pointers(indices)
if input is null then return -1.
check mid of array
if mid = target return mid strightaway.
If not then check which side is sorted, whichever side is sorted then check if the range can include target
if yes move low/high to that section and repeat
until nums[mid] == target.

"""



class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low)//2
            if nums[mid] == target:
                return mid
            else:
                # left sorted
                if nums[low] <= nums[mid]:
                    if nums[low] <= target and nums[mid]>target:
                        high = mid - 1
                    else:
                        low = mid + 1
                else:
                    if nums[mid] < target and nums[high] >= target:
                        low = mid + 1
                    else:
                        high = mid - 1
        return -1
