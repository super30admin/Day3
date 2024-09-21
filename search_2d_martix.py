from typing import List


# Todo: solution with O(log (m*n)) or O(log m + log n)
class Solution:
    def brute_force_searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        """
        Use linear search to find the target in matrix
        :param matrix: 2-D matrix
        :param target: to search
        :return: True if target found else False
        Runs in O(n) time complexity
        """
        num_rows = len(matrix)
        num_cols = len(matrix[0])

        for r in range(num_rows):
            for c in range(num_cols):
                if matrix[r][c] == target:
                    return True

        return False

    def binary_search(self, matrix, r, c, target):
        lo = 0
        hi = c

        while lo <= hi:
            mid = lo + (hi - lo) // 2
            if matrix[r][mid] == target:
                return True
            elif matrix[r][mid] < target:
                lo = mid + 1
            else:
                hi = mid - 1

    def searchMatrix_1(self, matrix: List[List[int]], target: int) -> bool:
        """
        This is O( m + log(n)) solution
        The idea is for each row find if target lies there and then do the binary search on that row.
        Note reverse is not possible O( n + log(m)) meaning search for col which have target and then do
        binary search on that row.
        :param matrix: 2-D matrix
        :param target: to search
        :return: True if target found else False
        """
        num_rows = len(matrix)
        num_cols = len(matrix[0])

        for r in range(num_rows):
            if target <= matrix[r][num_cols - 1]:  # check if target is in this row
                is_found = self.binary_search(matrix, r, num_cols - 1, target)
                return is_found

    def searchMatrix_2(self, matrix: List[List[int]], target: int) -> bool:
        """
        This is O( m * log(n)) / O( n * log(m)) solution
        The idea is to check if the target is in a row using binary search
        Note: check in each column can be done
        :param matrix: 2-D matrix
        :param target: to search
        :return: True if target found else False
        """
        num_rows = len(matrix)
        num_cols = len(matrix[0])

        for r in range(num_rows):
                is_found = self.binary_search(matrix, r, num_cols - 1, target)
                return is_found


obj = Solution()
ans = obj.searchMatrix_2([[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], 3)
print(ans)
