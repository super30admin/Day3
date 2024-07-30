class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        row = len(matrix)
        col =len(matrix[0]) 
        low = 0
        high = row*col -1

        while low<=high:
            mid = low+(high-low)//2
            r = mid//col
            c = mid%col

            if matrix[r][c] == target:
                return True
            if matrix[r][c] <= target:
                low = mid+1
            else:
                high = high-1
        return False