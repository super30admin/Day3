class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        if matrix == 0 or len(matrix) == 0:
            return False

        m = len(matrix)  
        n = len(matrix[0])
        

        low = 0
        high = (m*n) - 1

        while(low <= high):
            mid = low + (high - low) // 2
            row = mid // n 
            col = mid % n
            if matrix[row][col] == target:
                return True
            elif matrix[row][col] < target:
                low = mid +1
            else:
                high = mid -1      

        return False

        # for row in matrix:
            
        #     low = 0
        #     high = len(row)-1
        #     while(low<=high):
        #         mid = low + (high-low) // 2
        #         if row[mid] == target:
        #             return True

        #         if row[mid] < target:
        #             low = mid +1
        #         else:
        #             high = mid -1        
        
        # return False




        