class Solution(object):
    def search(self, nums, target):
      low, high = 0, 1
        

      while nums[high] <= target:
        low = high
        high = 2 * high
          
      while low <= high:
        mid = low + (high - low) // 2
          
        if (target == nums[mid]):
          return mid
          
        if (target <= nums[mid]):
          high = mid - 1
        else:
          low = mid + 1
      return -1
          
nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]   
solution = Solution()  # Create an instance of the class
print(solution.search(nums, 13))  # Call the search method on the instance