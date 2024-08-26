# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this :No 
def search(self, nums: List[int], target: int) -> int:

    if not nums or len(nums) == 0:
        return -1 
    
    low = 0
    high = len(nums) - 1
    while low <= high:
        mid  = low + (high - low ) // 2
        # check mid for target
        if nums[mid] == target:
            return mid
        # check if left is sorted
        elif nums[low] <= nums[mid]:
            if nums[low]<= target and target < nums[mid]:
                # reject right
                high = mid - 1
            else:
                # reject left
                low = mid + 1
        # right sorted
        else:
            if target <=nums[high] and nums[mid] < target:
                # reject left
                low = mid + 1
            else:
                # reject right
                high = mid - 1
        # check for when low and high are equal 
    if nums[high] == target:
        return low 
    # couldn't find return -1
    return -1
        

    