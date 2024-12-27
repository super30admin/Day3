#space complexity: O(1)
#Time Complexity: O(log(m * n))
# run on leetcode: yes
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        low= 0
        high= (len(matrix)* len(matrix[0]))-1
        # print('high', high)
        while( low <= high):
            mid= int(low + (high-low)/2)
            row = int(mid/len(matrix[0]))
            col = int(mid%len(matrix[0]))
            # print('mid element', matrix[row][col])
            if(matrix[row][col] == target):
                return True
            elif ( matrix[row][col] >= target):
                high = mid -1
            else:
                low = mid + 1
        return False
     
