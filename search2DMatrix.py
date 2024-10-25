# // Time Complexity : log(m)+log(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Calculating mid required "//" instead of '/'. Accidently used 'm' instead of "mid"

# // Your code here along with comments explaining your approach in three sentences only
# Imagine the 2D array as a simple array. Then find a middle element and compare it with the target.
# Do binary search using that middle element and target. 

class Solution:
    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:
        m = len(matrix)                 # m = rows
        n = len(matrix[0])              # n = columns
        low, high = 0, m*n-1            # 2 pointers

        while low <= high:
            mid = low +(high-low)//2    # find mid. Used "//"
            r = mid // n
            c = mid % n
            if matrix[r][c] == target:  # target found RETURN True
                return True
            elif matrix[r][c] > target: # target lies to the left of mid
                high = mid - 1
            else:                       # target lies to right of mid
                low = mid + 1

        return False                    # target not found RETURN False
    
x  = Solution.searchMatrix(self = Solution(), matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 4)
print(x)






# arr  = [[1,2,3],[4,5,6]]
# x = 5
# result = Solution().searchMatrix(arr, x)
# print(result)


# Bruteforce linear search thru matrix O(n^2) Works
# class Solution:
#     def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
#         for i in matrix:
#             if target in i:
#                 return True
#         return False