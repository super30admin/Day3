class Solution:
    def search(self, nums: List[int], target: int) -> int:

        left = 0
        right = len(nums)-1
        while left<=right:
            mid = (left+right)//2

            if target == nums[mid]:
                return mid
            
            elif (left == mid == right) : 
                return -1
            
            elif nums[mid]>=nums[left]:
                if nums[left]<=target<nums[mid]:
                    right = mid
                else:
                    left = mid+1
            
            else:
                if nums[mid]<target<nums[left]:
                    left = mid+1
                else:
                    right = mid
        return -1
        
