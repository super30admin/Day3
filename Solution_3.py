class Solution(object):
    def searchMatrix(self, matrix, target):
        r = len(matrix)
        c = len(matrix[0])
        startR, startC = 0, c - 1
        # print(r,c)
        while startR < r and startC >= 0:
            if target == matrix[startR][startC]:
                return True
            elif target > matrix[startR][startC]:
                startR += 1
            else:
                startC -= 1
        return False