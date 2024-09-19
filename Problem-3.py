'''
    Time Complexity: O(logn)
    Space Complexity: O(1)
    Ran successfully on leetcode
    Difficulty: Had solved it before, so was relatively easy
'''
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)

        for i in range(m):
            n = len(matrix[i])
            l, r = 0, n - 1

            if matrix[i][l] <= target <= matrix[i][r]:
                while l <= r:
                    mid = (l+r)//2

                    if matrix[i][mid] == target: 
                        return True
                    elif matrix[i][mid] < target:
                        l = mid + 1
                    else:
                        r = mid - 1

        return False