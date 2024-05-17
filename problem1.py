'''
Time Complexity : O(logm + logn) for both the solutions where m = #rows; n = #cols
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
'''

# Solution 1: Binary search over expanded 1-D array of length m*n and then computing row and col values

class Solution1:
  def searchMatrix(self, matrix, target):
    nrows = len(matrix)
    ncols = len(matrix[0])
    low = 0
    high = nrows * ncols - 1
    while low <= high:
      mid = (low + high) // 2
      row = mid // ncols
      col = mid % ncols
      if matrix[row][col] == target:
        return True
      elif target < matrix[row][col]:
        high = mid - 1
      else:
        low = mid + 1
    return False

# Solution 2: First find the row using binary search, then do binary search on that row

class Solution2:
  def searchMatrix(self, matrix, target):
    nrows = len(matrix)
    ncols = len(matrix[0])
    r1 = 0
    r2 = nrows - 1
    while r1 <= r2:
      midRow = (r1 + r2) // 2
      if target < matrix[midRow][0] :
        r2 = midRow - 1
      elif target > matrix[midRow][ncols-1]:
        r1 = midRow + 1
      else:
        return self.findElementInRow(matrix[midRow], target)
    return False

  def findElementInRow(self, array, target):
    low = 0
    high = len(array) - 1
    while low <= high:
      mid = (low + high) // 2
      if array[mid] == target:
        return True
      elif array[mid] > target:
        high = mid - 1
      else:
        low = mid + 1
    return False

matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
target1 = 16
target2 = 12
target3 = 60
target4 = 22

obj1 = Solution1()
print('Search {} using Solution 1: {}'.format(target1, obj1.searchMatrix(matrix,target1)))
print('Search {} using Solution 1: {}'.format(target2, obj1.searchMatrix(matrix,target2)))
print('Search {} using Solution 1: {}'.format(target3, obj1.searchMatrix(matrix,target3)))
print('Search {} using Solution 1: {}'.format(target4, obj1.searchMatrix(matrix,target4)))

obj2 = Solution2()
print('Search {} using Solution 2: {}'.format(target1, obj2.searchMatrix(matrix,target1)))
print('Search {} using Solution 2: {}'.format(target2, obj2.searchMatrix(matrix,target2)))
print('Search {} using Solution 2: {}'.format(target3, obj2.searchMatrix(matrix,target3)))
print('Search {} using Solution 2: {}'.format(target4, obj2.searchMatrix(matrix,target4)))
