# Time Complexity :- O(log(m * n))
# Space Complexity :- 0(n)
#sucessfully run on leetcode :- Yes
class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix or not matrix[0]:
            return False

        m = len(matrix);
        n = len(matrix[0]);
        low = 0
        high = m * n - 1

        while low <= high:
            mid = low + (high -low) / 2

            r = mid / n
            c = mid % n

            if  matrix[r][c] == target:
                return True

            if matrix[r][c] > target :
                high = mid - 1
            else:
                low = mid+1

        return False   
        