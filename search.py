class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
			l,r = 0, len(nums) - 1 
			
			while l <= r:
				mid = (l + r) //2 
				
				if nums[mid] == target:
					return mid
					
				if nums[l] <= nums[mid]:
					if nums[left] <= target <= nums [mid]:
						r= mid -1 1 
					else: 
						l = mid + 1  
					
				
				else: 
            if nums[mid] < target <= nums[right]:
				      left = mid + 1
					  else:
		        right = mid - 1
		        
        return -1
