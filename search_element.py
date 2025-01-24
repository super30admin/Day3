'''
Time Complexity :
log(m * n)
Space Complexity : O(m * n)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : No
'''

def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        m,n=len(matrix),len(matrix[0])
        left, right = 0, m * n - 1
        while(left<=right):
            mid=(left+right)//2
            value=matrix[mid//n][mid%n]
            if value==target:
                return True
            if value<target:
                left = mid+1
            elif value>target:
                right = mid-1
        return False