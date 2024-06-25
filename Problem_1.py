"""
## Problem1 
Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
TC: O(logn)
SC: O(1)

"""

# Approch - 1:  Searching using BS, imagining the 2-D array as 1-D

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
    
        first = 0
        last = (len(matrix) * len(matrix[0])) - 1
        row = len(matrix)
        col = len(matrix[0])
        while (first <= last):
            mid = (first + last)//2
            r = mid//col
            c = mid % col
            
            print("row", r, "col", c)
            
            if (matrix[r][c] == target):
                return True
            
            elif (matrix[r][c] > target):
                last = mid -1
                
            else:
                first = mid + 1
                
        return False
        
# Approch 2: searching using BS by applying BS on col to find the correct row and then row to find the right 
#col
class Solution:
    def findRow(self, matrix, r, c, target):
        l = 0 
        h = r -1
        while (l <= h):
        
            mid = (l+h)//2
           
            if  (mid == 0 or matrix[mid - 1][c] < target) and matrix[mid][c] >= target:
                return mid
            
            elif matrix[mid][c] > target:
                h = mid -1 
            else:
                l = mid + 1
                
        return -1
            
                
            
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        r = len(matrix) - 1
       
        c = len(matrix[0]) - 1
        
        high = c
        
        row = self.findRow(matrix, r, c, target)
       
        low = 0
        
        while (low <= high):
            
            mid = (low+high)//2
            if(matrix[row][mid]) == target:
                return True
            
            elif matrix[row][mid] > target:
                high = mid - 1
                
            else:
                low = mid + 1
                
        return False
            
        
                 