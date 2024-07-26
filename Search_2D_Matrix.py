# time complexity O(log m + log n)
# space complexity O(1)
# tested on leetcode
# Using binary search to find the row and 
# then finding the element in the row determined in the first step
# 6 solutions exist for this problem O(m*n),O(m+n), O(mlog n), O(nlogm), O(logm + logn)

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # find row
        rows = len(matrix)
        cols = len(matrix[0])
        low = 0
        high = rows - 1
        row = None
        while (low <= high):
            mid = (low + high) // 2
            if matrix[mid][0] <= target <= matrix[mid][cols - 1]:
                # // row found find col now
                row = mid
                break
            elif target > matrix[mid][cols - 1]:
                low = mid + 1
            else:
                high = mid - 1
        print("row ", row)
        if row == None:
            return False
        low = 0
        high = cols - 1
        while (low <= high):
            mid = (low + high) // 2
            if matrix[row][mid] == target:
                return True
            elif matrix[row][mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return False
    

# time complexity - O(m*n)
# space complexity - O(1)
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
 
        # assume 2d as 1d array
        rows = len(matrix)
        cols = len(matrix[0])
        low = 0
        high = rows - 1
        row = None
        while (low <= high):
            mid = (low + high) // 2
            if matrix[mid][0] <= target <= matrix[mid][cols - 1]:
                # // row found find col now
                row = mid
                break
            elif target > matrix[mid][cols - 1]:
                low = mid + 1
            else:
                high = mid - 1
        print("row ", row)
        if row == None:
            return False
        low = 0
        high = cols - 1
        while (low <= high):
            mid = (low + high) // 2
            if matrix[row][mid] == target:
                return True
            elif matrix[row][mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return False