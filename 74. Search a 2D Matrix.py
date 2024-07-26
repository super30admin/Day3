### Perform binary search on the 'rows' to isolate which row has the target (O log m)
###                                  + 
### Perform binary search on the specific row (o log n)
### Time Complexity - O (log (m + n)) 

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        ROW = len(matrix)
        COL = len(matrix[0])

        top = 0
        bot = ROW - 1

        ## First we try to find which row contains our target
        ## If number doesn't exist, our top pointer will exceed the back pointer, which means target not found

        while top <= bot:
            row = (top + bot) // 2

            if(target > matrix[row][-1]):
                top = row + 1
            
            elif(target < matrix[row][0]):
                bot = row - 1
            else:
                break
        
        if top > bot:
            return False

        l = 0
        r = COL -1

        ## once we know which row has our target, we perform binary search on it
            
        while(l <= r):
            mid = (l + r) // 2
            if target < matrix[row][mid]:
                r = mid - 1
            elif target > matrix[row][mid]:
                l = mid + 1
            else:
                return True
        
        return False
        


        
