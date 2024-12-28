class Solution:
    
    def search(self, nums: List[int], target: int) -> int:

        pivotIndex = self.findMin(nums)

        if nums[pivotIndex] <= target <= nums[-1]:
            return self.binarySearch(nums, pivotIndex-1, len(nums)-1, target)
        else:
            return self.binarySearch(nums, -1, pivotIndex, target)


    def binarySearch(self, nums, low, high, target):
        low = low
        high = high

        while low+1<high:
            mid = (low+high)//2

            if nums[mid]>=target:
                high = mid
            else:
                low = mid 
        return high if nums[high]== target else -1                  


    def findMin(self, nums):
        low, high = -1, len(nums)-1

        while low+1<high:
            mid = (low+high)//2

            if nums[mid]<= nums[-1]:
                high = mid
            else:
                low = mid
        return high                


        
