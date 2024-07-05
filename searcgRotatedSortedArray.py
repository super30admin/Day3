class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums) == 0:
            return -1
        start = 0
        end = len(nums)-1
        while start <= end:
            mid = start +(end-start)//2
            if nums[mid] == target:
                return mid
            if nums[start] <= nums[mid]: # if left part is sorted 
                if nums[start] <= target and nums[mid]> target:
                    end = mid -1
                else:
                    start = mid+1
            else: # right part is sorted
                if nums[mid] < target and nums[end] >= target:
                    start = mid+1
                else:
                    end = mid-1
            
        return -1

sol = Solution()
    
nums = [4, 5, 6, 7, 0, 1, 2]
target = 0
print(sol.search(nums, target))  # Output: 4 (index of target in nums)
    
target = 3
print(sol.search(nums, target))  # Output: -1 (target not found in nums)

        
