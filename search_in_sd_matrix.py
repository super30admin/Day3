class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        no_rows, no_columns = len(matrix), len(matrix[0])

        low_row, high_row = 0, no_rows - 1

        while(low_row <= high_row):
            mid_row = (low_row + high_row) // 2

            if target < matrix[mid_row][0]:
                high_row = mid_row - 1
            elif target > matrix[mid_row][-1]:
                low_row = mid_row + 1
            else:
                break

        if not (low_row <= high_row):
            return False

        main_row = (low_row + high_row) // 2
        low, high = 0, no_columns - 1

        while(low<=high):
            mid = (low + high) // 2

            if target < matrix[main_row][mid]:
                high = mid - 1
            elif target > matrix[main_row][mid]:
                low = mid + 1
            else:
                return True
        return False


        