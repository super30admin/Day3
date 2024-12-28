class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        left = 0 
        right = m*n -1 
        while left <= right:
            pivot_index = left + ( right- left)//2
            row = pivot_index // n
            col = pivot_index % n
            pivot_element = matrix[row][col]

            if pivot_element == target:
                return True 
            elif (target < pivot_element):
                right = pivot_index -1 
            else:
                left = pivot_index + 1
        return False