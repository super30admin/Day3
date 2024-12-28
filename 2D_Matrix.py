class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # Rowise check if the element present in the row if yes perform BS in that row 
        # TC - O(m + logn)
        # SC - O(1)

    #     if (len(matrix) == 0 ):
    #         return False

    #     rows = len(matrix)
    #     col = len(matrix[0])

    #     for i in range(rows):
    #         # Check if the target lies within the range of the current row
    #         if matrix[i][0] <= target <= matrix[i][col - 1]:
    #             # Perform binary search in that row
    #             if self.binarySearch(matrix[i], target):
    #                 return True
    #     return False

    # def  binarySearch(self,matrix,target):
    #     low = -1
    #     high = len(matrix)-1

    #     while (low + 1)<high:
    #         mid = (low+high)//2

    #         if matrix[mid]>=target:
    #             high = mid
    #         else:
    #             low = mid   
    #     return True if matrix[high] == target  else False        



        
        
        # Optimize Solution of performing Binary Search on whole matrix
        # TC - O(log(mn))
        # SC - O(1)
        if (len(matrix) == 0 ):
            return False

        rows = len(matrix)
        columns = len(matrix[0])
        length_of_matrix = rows*columns
        low = 0
        high = length_of_matrix-1

        while low<=high:
            mid = (low + high)//2
            mid_row = mid//columns
            mid_column = mid%columns

            if matrix[mid_row][mid_column] == target:
                return True
            elif(matrix[mid_row][mid_column] > target):
                high = mid -1
            else:
                low = mid+1
        return False        
