#TC: O(log n) - used binary search
#SC: O(1)

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        left = 0
        right = len(nums)-1

        while left<=right:
            mid = (left + right) //2

            if nums[mid] == target:
                return mid
            
            #Check if left half is sorted
            if nums[left] <= nums[mid]:
                #target is in left half
                if nums[left] <= target < nums[mid]:
                    right = mid - 1
                else: #target in right half
                    left = mid + 1
            #Check sorted right half
            else:
                #Target in right half
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                #target in left half
                else:
                    right = mid - 1
        return -1
    
