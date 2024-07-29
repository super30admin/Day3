class Solution(object):
    def BinSearch(self, nums, low, high, target):
        while low <= high:
            mid = low + (high - low)/2
            if target == nums[mid]:
                return mid
            elif target < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        return -1
    def search(self, nums, target):
        # find mid, check at mid, find which side is sorted
        # check if element lies in sorted side- binary search
        # else goto other side - check mid and repeat
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = low + (high - low) / 2
            if nums[mid] == target:
                return mid
            else:
                if nums[low] <= nums[mid]: # left side is sorted
                    if target >= nums[low] and target < nums[mid]:
                        # target is in the sorted left side
                        return self.BinSearch(nums, low, mid - 1, target)
                    else:
                        # element is in the right side - which is unsorted
                        low = mid + 1
                else:
                    if nums[mid] < nums[high]: #right side is sortd
                        if target > nums[mid] and target <= nums[high]:
                            # target is in right sorted side
                            return self.BinSearch(nums, mid+1, high, target)
                        else:
                            high = mid - 1
        


        return -1