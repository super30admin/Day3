class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        #treat matrix as 1d array
        mat_size=len(matrix)
        no_of_cols=len(matrix[0])
        l=0
        h=(mat_size*no_of_cols)-1

        while l<=h:
            mid = (l + h)//2
            r=mid//no_of_cols
            c=mid%no_of_cols

            if matrix[r][c]==target: 
                return True 
            elif matrix[r][c]>target:
                h= mid-1
            else:
                l =mid+1
        return False

#TC: O(M*N)
#SC: O(1)