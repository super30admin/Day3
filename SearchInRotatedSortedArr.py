class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if nums == None or len(nums) == 0:
            return -1
        
        n = len(nums)
        low = 0
        high = n-1
        while low <= high:
            #mid = (low + high)//2
            mid = low +(high-low)//2 # prevent integer overflow
            if nums[mid] == target:
                return mid
            #left sorted
            if nums[low] <= nums[mid]:
                #check if element lies in sorted part
                if nums[low] <= target and nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                #right sorted
                if nums[mid] < target and nums[high] >= target:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1
        