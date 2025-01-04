class Solution:
    def search(self, nums: List[int], target: int) -> int:
        start, end = 0, len(nums) - 1
    # *********************** In ROTATED SORTED ARRAY **********ATLEAST ONEHALF WILL BE ALWAYS SORTED
        while(start <= end):
            mid = (start + end)//2
            if nums[mid] == target:
                return mid
            elif (nums[start] <= nums[mid]): # check if left half is sorted or not
                if (nums[mid] > target) and (nums[start] <= target): # if left half is sorted check if target lies inleft
                    end = mid - 1 # move end to left half
                else:
                    start = mid + 1 # move start to other side (right half)
            else: # Right side will be sorted
                if (target > nums[mid]) and (target <= nums[end]): # check if target lies in the right half
                    start = mid + 1   # move start here
                else:
                    end = mid - 1
        
        return -1