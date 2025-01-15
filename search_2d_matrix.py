class Solution(object):
    def searchMatrix(self, matrix, target):
        toCheck = 0
        while(max(matrix[toCheck]) < target and toCheck < len(matrix)-1):
            toCheck+=1
        low = 0
        mid = 0
        high = len(matrix[toCheck])-1
        while low <= high:
            mid = (high-low) + low
            if(matrix[toCheck][mid]==target):
                return True
            if(matrix[toCheck][mid] < target):
                low = mid + 1
            else:
                high = mid-1
        return False