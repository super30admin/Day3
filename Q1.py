######### Search in a 2-D Matrix ###########

# Time Complexity : O(log(m*n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Initially made mistake in the index computation.

# Similar to performing normal binary search except compute indexes based on the grid to get element at mid.

def matrix_search(matrix, target):
    if not matrix or len(matrix)==0:
        return False
    n = len(matrix)
    m = len(matrix[0])
    l = 0
    r = (m*n) - 1
        
    while l <= r:
        mid = (l+r)//2
        x = mid // m
        y = mid % m
        if matrix[x][y] == target:
            return True
        elif matrix[x][y] > target:
            r = mid - 1
        else:
            l = mid + 1
    return False

print(matrix_search([[1,4,5,8],[12,13,16,19],[22,24,25,26]],16))
