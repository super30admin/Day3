#time complexity = O(logn)
# space complexity = O(1)


class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        low,high = 0, len(nums)- 1
        
        while(low <= high):
            mid = low + (high - low) / 2    #calculate middle index
            if nums[mid] == target:  
                return mid

            if nums[low] <= nums[mid]:
                #if target in the left half
                if nums[low] <= target < nums[mid]:
                    high = mid - 1
                else:
                        low = mid +1

            else:
                #if the target in the right side
                if nums[mid] < target <= nums[high]:
                    low = mid +1
                else:
                    high = mid - 1
        #if target not found
        return -1