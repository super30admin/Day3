# Time Complexity : O(log(m*n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
class BinarySearch2D: 
    # Assume this 2D matrix to be a 1D matrix and do Binary search on it. The position of the middle element can be calculated using the row and column values, which are calculated using the size of the colums. The row is the divisor and the column is the remainder of the position of the middle element. Return false if the target is not found.
    def searchMatrix(self, matrix, target):
        if not matrix or not matrix[0]:
            return False
        
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = m * n - 1

        while low <= high:
            mid = low + (high - low) // 2
            row = mid // n
            col = mid % n
            
            if matrix[row][col] == target:
                return True
            elif matrix[row][col] > target:
                high = mid - 1
            else:
                low = mid + 1
        
        return False

# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class BinarySearchRotated:
    # Find the middle element. Compare the middle element with the low and high element to see which side is still sorted. If the target is in the range of the sorted side, do a Binary search there, else increment or decrement the low or high value accordingly to move closer to the target value. If the target is not found, return -1.
    def search(self, nums, target):
        if not nums:
            return -1
        
        low, high = 0, len(nums) - 1
        
        while low <= high:
            mid = low + (high - low) // 2
            
            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]:
                # Left side is sorted
                if nums[low] <= target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                # Right side is sorted
                if nums[mid] < target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        
        return -1


# Example usage
# Problem - 1
print("===================PROBLEM-1===================")
binarySearch2d = BinarySearch2D()
matrix = [
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 60]
]
target = 3
print(binarySearch2d.searchMatrix(matrix, target))  # Output: True

target = 13
print(binarySearch2d.searchMatrix(matrix, target))  # Output: False

# Problem - 2
print("===================PROBLEM-2===================")
binarySearchRotated = BinarySearchRotated()
nums = [4, 5, 6, 7, 0, 1, 2]
target = 0
print(binarySearchRotated.search(nums, target))  # Output: 4

target = 3
print(binarySearchRotated.search(nums, target))  # Output: -1

