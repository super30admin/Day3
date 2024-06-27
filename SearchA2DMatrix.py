#The searchMatrix function searches for a target number in a 2D matrix sorted row-wise and column-wise. It treats the matrix like a long, sorted list and uses binary search. It calculates a middle point, checks the value at that position, and compares it to the target. If it matches, the function returns True. If the middle value is smaller than the target, it searches the right half of the "list"; if larger, it searches the left half. This continues until the target is found or there are no more elements to check. This method is fast with a time complexity of O(log(m*n)), where m and n are the matrix dimensions, and it uses minimal extra space (O(1)).


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        if not matrix or not matrix[0]:
            return False

        rows, cols = len(matrix), len(matrix[0])

        start, end = 0, (rows * cols) - 1

        while start <= end:

            mid = (start + end) // 2
            mid_value = matrix[mid // cols][mid % cols]

            if mid_value == target:
                return True
            elif mid_value < target:
                start = mid + 1
            else:
                end = mid - 1
        
        return False
