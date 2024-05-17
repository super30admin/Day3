# Time Complexity :

# O(LOG(M*N)) 


# Space Complexity :  

# O(1), since oyou are just searching, not creating new matrix/array



# Approach:
# Start with left and right pointer and recursively divide the search range 
# based on the mid value comparison with target value

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        left = 0               #left pointer
        rows = len(matrix)
        cols = len(matrix[0])
        print("Rows and cols: ", rows, ":", cols)
        right = rows*cols-1    #right pointer

        if (rows==0 and cols==0) or not matrix:
            return False

        # Loop over untill Left=Right
        while(left<=right):
            middle = (left + right) // 2  # this index is in 1D array

            #formula to convert the 1d index to 2d index
            row = middle // cols
            col = middle % cols
            print("Current Middle,  Row and col: ", middle, ":", row, ":", col)

            if matrix[row][col] == target:
                # you found the element at this middle position
                return True

            if matrix[row][col] > target:
                # move left and update left and right pointers
                right = middle-1
                
            else:
                # move right
                left = middle+1
           

        return False