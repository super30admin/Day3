# Search a 2D Matrix_Solution_Q1

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if matrix == None or len(matrix) ==0:
            return False
        
        m= len(matrix)
        n= len(matrix[0])

        low=0
        high= m*n - 1
        
        while low <= high:
            mid= low + (high-low) // 2
            row= mid//n
            col=mid%n
            if matrix[row][col]==target:
                return True
            elif target > matrix[row][col]:
                low = mid +1
            else:
                high = mid -1
        return False 

#TC: O(log mn)
#SC: O(1)

-------------------------------------------------------------------------------------------------------

# Search in a Rotated Sorted Array_Solution_Q2

class Solution:
    def search(self, nums: List[int], target: int) -> int:

        if nums== None or len(nums)==0:
            return -1

        low= 0
        high= len(nums) - 1
        n= len(nums)

        while (low <= high):
            mid= (low+high) // 2

            if nums[mid] == target:
                return mid

            #left sorted
            if nums[low] <= nums[mid]:
                if nums[low] <= target and nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
                
            #right sorted    
            else:
                if nums[high] >= target and nums[mid] < target:
                    low = mid+1
                else:
                    high= mid- 1
        return -1

# TC log n
# SC O(1)

-------------------------------------------------------------------------------------------------------

# Search in a Sorted Array of Unknown Size_Solution_Q3

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low= 0
        high= 1
        
        while reader.get(high) < target:
            low= high
            high= high * 2
        
        return self.binarySearch(reader, target, low, high)

    def binarySearch(self, reader: 'ArrayReader', target: int, low: int, high:int) -> int:
        while low <= high:
            mid= low + (high - low) // 2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                low = mid+1
            else:
                high = mid-1
        return -1

#TC: O(logn)
#SC: O(1)
