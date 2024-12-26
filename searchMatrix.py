class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix or not matrix[0]:
	        return False
        
        m, n = len(matrix), len(matrix[0])
        l,r = 0, m * n-1
        
        while l < r:
	        mid = (l+r) // 2
	        row, col = mid // n , mid % n
	        val = matrix[row][col]
	        
            if val == target:
                return True
            elif val < target: 
                l = mid +1 
            else:
                r = mid - 1
        return False
