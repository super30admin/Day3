# 74. Search a 2D Matrix
# Time Complexity: O(log(n)*log(m))
# Approach: First Do horizontal binary search on mid row then in binary fashion move to the
# next row until element is found or indexes reach their bounds. 
class Solution:
    def h_b_search(self,nums,left,right,target):
        res = -1
        while left <= right:
            mid = (right + left)//2
            if nums[mid] == target:
                res = mid
                break
            elif nums[mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        return res
    
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        top = 0
        bottom = len(matrix)-1
        answer = -1
        while top <= bottom:
            mid = (bottom+top)//2
            if self.h_b_search(matrix[mid],0,len(matrix[mid])-1,target) == -1:
                if matrix[mid][0] > target:
                    bottom = mid - 1
                else:
                    top = mid + 1
            else:
                answer = self.h_b_search(matrix[mid],0,len(matrix[mid])-1,target)
                print(mid,answer)
                break
        if answer == -1:
            return False
        else:
            return True