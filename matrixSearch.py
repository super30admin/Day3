class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m=len(matrix)
        n=len(matrix[0])
        end=m*n-1
        start=0
        while(start<=end):
            mid=(start+end)//2
            ele=matrix[mid//n][mid%n]
            if(ele==target):
                return True
            elif ele<target:
                start=mid+1
            else:
                end=mid-1
        return False

        