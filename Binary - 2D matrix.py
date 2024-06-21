## Problem1 
# Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
# Time Complexity : O(m) + log(n) . Search of inner lists to find candidate + binary search
# Space Complexity : O(1) No extra space created
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, it was related to OOPs fundamentals, did not add self while creating or calling binarypresense


# Your code here along with comments explaining your approach in three sentences only
# Tried to find candidate list by iterating over all lists' 0th and -1st index
# if we have a candidate run binary search on it.

class Solution:
    def binarypresense(self,arr, target):
        low, high = 0 , len(arr)-1
        while low <= high:
            mid  = low + (high - low)//2
            if arr[mid] == target:
                return True
            elif arr[mid] <=target:
                low = mid+1
            else:
                high = mid - 1
        
        return False

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        mylist = None
        i = 0
        while i < len(matrix)-1:
            if matrix[i][0] <=target <= matrix[i+1][0]:
                if matrix[i][0] == target:
                    return True
                elif matrix[i+1][0] == target:
                    return True
                else:
                    mylist = matrix[i]
            i+=1

        if mylist is None:
            if matrix[i][0] <=target <= matrix[i][-1]:
                if matrix[i][0] == target:
                    return True
                elif matrix[i][-1] == target:
                    return True
                else:
                    mylist = matrix[i]
            else:
                return False
        return self.binarypresense(mylist,target)
