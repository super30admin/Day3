# Approach : In this probelm as well we are reducing sequence by half logic
# Time Complexity : O(log(m*n))
# m = rows
# n = cols 

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m=len(matrix)
        n=len(matrix[0])
        low=0
        high=m*n-1

        while low<=high:
            mid=low+(high-low)//2
        # This is important to figure out in which row and col will can get the target 
        # R-0[1,3,6,7,9]
        # R-1[10,15,18,19,25]
        # R-2[27,29,33,37,40]
        # R-3[41,43,45,47,49]
        # Take example 3( so middle element is at index 9th, we have total elements from 0th index to 19th index)
        # now for row=9//5= 1 and col = 9%5= 4
    
            row=mid // n
            col=mid % n

            if matrix[row][col]==target:
                return True
    
            elif matrix[row][col]<target:
                low=mid+1
            else:
                #Now for above example elemnent 3 the matric[1][4]=25 25>3(target) so will shift high to mid -1
                # new high = 8th index 
                # again mid= 0+(8-0)//2=4
                # now row = 4//5 =0 and col=4%5=4
                #[0,4]=9 again target is greater 
                # high=3rd index mid=3//2 =1
                #row=1//5=0 and col=1%5=1
                # now [0,1]=3 i.e (equal to target so output will be true)
                high=mid-1
        return False