from typing import List
#Time complexity: O(logm*n) to binary search throgh total number of elements
#Space complexity: O(1) No additional space
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m, n = len(matrix), len(matrix[0])
        low, high = 0, m*n-1
        while low <= high:
            mid = low +(high - low)//2
            r, c = mid//n, mid%n
            if matrix[r][c] == target:
                return True
            if matrix[r][c] < target:
                low = mid +1
            else:
                high = mid -1
        return False
            

s = Solution()
matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
target = 10
print(s.searchMatrix(matrix, target))
