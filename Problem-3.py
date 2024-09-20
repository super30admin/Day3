'''
    Time Complexity: O(log(mxn))
    Space Complexity: O(1)
    Ran successfully on leetcode
    Difficulty: Used the mlogn solution before but updated it to log(mn) solution
'''
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        low, high = 0, m*n - 1
        

        while low <= high:
            mid = low + (high - low)//2

            r = mid // n
            c = mid % n

            if matrix[r][c] == target:
                return True
            elif matrix[r][c] < target:
                low = mid + 1
            else:
                high = mid - 1

        return False