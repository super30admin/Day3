'''
Time: 0(log mn)
Space: 0(1)
Approach:
    1. Consider 2d matrix like a single array
    2. Perform binary search on this entire array
'''
class Solution:
    
    def __init__(self):
        self.rows = 0
        self.columns = 0
        self.total = 0
    
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        self.rows = len(matrix)
        self.columns = len(matrix[0])
        self.total = self.rows * self.columns
        
        
        low = 0
        high = self.total - 1
        
        while(low <= high):
            
            mid = (high-low)//2 + low
            
            # get r and c index
            r = mid // self.columns
            c = mid % self.columns
            
            # case-1
            if(matrix[r][c] == target):
                return True
            
            # case-2 
            elif matrix[r][c] < target:
                # check on rhs
                low = mid + 1
            
            
            # case-3
            elif matrix[r][c] > target:
                # check on lhs
                high = mid - 1
        
        '''end of while loop'''
        return False