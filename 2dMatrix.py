# time: O(log mn)
# space: O(1)

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        top, bottom = 0, len(matrix)-1
        l,r = 0, len(matrix[0])

        while top <= bottom:
            mid = (top+bottom)//2
            if target>=matrix[mid][0] and target<=matrix[mid][-1]:
                break
            elif target<matrix[mid][0]:
                bottom-=1
            else:
                top+=1

        while l<r:
            m = (l+r)//2
            if target<matrix[mid][m]:
                r-=1
            elif target>matrix[mid][m]:
                l+=1
            elif target==matrix[mid][m]:
                return True

        return False
