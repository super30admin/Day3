
"""
Time Compexity: O(logmn)
Sace Complexity: O(1)
"""
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        low, high = 0, (m*n) - 1

        while(low <= high):
            mid = (low+high)//2
            row = mid // n
            column = mid % n 

            if matrix[row][column] == target:
                return True

            elif matrix[row][column] > target:
                high = mid -1

            else:
                low = mid + 1

        return False


        