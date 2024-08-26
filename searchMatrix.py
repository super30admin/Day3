# Time Complexity : O(log(mn))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this :No
# Binary search through the matrix taking matrix as one array as elements are in ascending order in each row as well as column.
def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
    m = len(matrix)
    n = len(matrix[0])

    low = 0 
    high = m*n  - 1
    while low <= high:
        mid = low + (high-low)//2
        r = mid//n
        c = mid%n
        
        if matrix[r][c] == target:
            return True
        if matrix[r][c] > target:
            high = mid-1 
        else:
            low = mid + 1
    
    return False