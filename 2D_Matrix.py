#Time: O(log(m*n))
#Space: O(1)
#Yes this worked in leetcode

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        if m == 0:
            return False
        n = len(matrix[0])
        left,right = 0, m*n-1
        while left <= right:
            mid = left + (right-left) // 2
            mid_val = matrix[mid//n][mid % n]
            if target == mid_val:
                return True
            else:
                if target < mid_val:
                    right = mid-1
                else:
                    left = mid +1
        return False