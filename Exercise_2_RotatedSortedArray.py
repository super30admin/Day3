# Time Complexity :
# O(n) for findNode(), put(), get((), remove()


# Space Complexity : 
# O(n), since the linkedList attached to each index 
# in primary array will grow according to different key received


# Approach:
# Start with left and right pointers, find mid pointer.
# Then compare if the value at mid index is same as target
# If same, then return the index, else:
#  Check which side-of array the target lies
#  recursively perform binary search on that side of array to find the "target"

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        left = 0               # left pointer
        right = len(nums)-1    # right pointer

        if (not nums or len(nums)==0) :
            return -1

        while(left <= right):
            mid = (left+right) // 2   # mid index
            
            if nums[mid] == target:    # return if value at mid index is wqual to target
                return mid
            
            if nums[left] <= nums[mid]:  # check if left-side of the array(w.r.t mid) is sorted
                if(target>=nums[left] and target < nums[mid]):
                    right = mid-1
                else:
                    left = mid+1
            else:
                if(target>nums[mid] and target<=nums[right]):
                    left = mid+1
                else:
                    right = mid-1
        
        return -1