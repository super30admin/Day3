# Time Complexity : O(log (m * n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# My approach: imagined that the matrix is a 2d sorted array and performing binary search on it.
# Converting every index to corresponding matrix cell. 


left, right = 0, len(matrix) * len(matrix[0]) - 1
COLS = len(matrix[0])

while left <= right:
    mid = left + ((right - left) // 2)
    row = mid // COLS
    column = mid % COLS
    if matrix[row][column] == target:
        return True
    
    if target < matrix[row][column]:
        right = mid - 1
    else:
        left = mid + 1

return False