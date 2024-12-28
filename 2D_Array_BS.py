# Time Complexity :  O(log(m * n))
# Space Complexity : O(1)
# Leetcode : yes

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        low= 0
        high= (len(matrix)* len(matrix[0]))-1
        while( low <= high):
            mid= int(low + (high-low)/2)
            row = int(mid/len(matrix[0]))
            col = int(mid%len(matrix[0]))
            if(matrix[row][col] == target):
                return True
            elif ( matrix[row][col] >= target):
                high = mid -1
            else:
                low = mid + 1
        return False
     