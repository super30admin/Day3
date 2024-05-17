'''
Time Complexity : O(logn)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : I had to rewatch the explaination from the recording to understand the intuition properly
'''
class Solution:
  def search(self, nums, target):
    low = 0
    high = len(nums) - 1
    while low <= high:
      mid = (low + high) // 2
      if nums[mid] == target:
        return mid
      # if left sub array is sorted
      if nums[low] <= nums[mid] :
        # if target is in left sub array range
        if nums[low] <= target and nums[mid] > target:
          high = mid - 1 # move left
        else:
          low = mid + 1 # move right
      # if left sub array is not sorted, then right sub array is definitely sorted
      else:
        # if target is in right sub array range
        if nums[mid] < target and nums[high] >= target:
          low = mid + 1 # move right
        else:
          high = mid - 1 # move left
    return -1

obj = Solution()
nums = [10,11,12,1,2,3,4,5,6,7,8,9]
target1 = 11
target2 = 7
target3 = 15
target4 = 1
print('Search {}: {}'.format(target1, obj.search(nums, target1)) )
print('Search {}: {}'.format(target2, obj.search(nums, target2)) )
print('Search {}: {}'.format(target3, obj.search(nums, target3)) )
print('Search {}: {}'.format(target4, obj.search(nums, target4)) )
