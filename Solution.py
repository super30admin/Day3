// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only

# Problem 1
class Solution:
    
    #Time Complexity: O(log(m * n))
    #Space Complexity: O(1)

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # Check if the matrix is empty
        if not matrix:
            return False
        
        # Get the number of rows (m) and columns (n)
        m, n = len(matrix), len(matrix[0])
        
        # Initialize the search boundaries for binary search
        left, right = 0, m * n - 1

        while left <= right:
            # Calculate the middle index in the flattened matrix
            mid = (left + right) // 2
            # Convert the middle index to row and column indices
            mid_row, mid_col = divmod(mid, n)

            # Check if the middle element is the target
            if matrix[mid_row][mid_col] == target:
                return True
            # If the target is greater, ignore the left half
            elif matrix[mid_row][mid_col] < target:
                left = mid + 1
            # If the target is smaller, ignore the right half
            else:
                right = mid - 1

        return False


#Problem 2
class Solution:
    
    #Time Complexity: O(log n)
    #Space Complexity: O(1)
    
    def search(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1

        while left <= right:
            mid = (left + right) // 2

            if nums[mid] == target:
                return mid

            # Determine if the left half is sorted
            if nums[left] <= nums[mid]:
                if nums[left] <= target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            # Otherwise, the right half must be sorted
            else:
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1

        return -1

#Problem 3
class Solution:
    
    #Time Complexity: O(log n)
    #Space Complexity: O(1)
    

    def search(self, reader, target: int) -> int:
        
        # Initialize the bounds for the binary search
        left, right = 0, 1

        # Increase the right bound exponentially until the target is within the range or an out-of-bounds access occurs
        while True:
            try:
                if reader.get(right) == target:
                    return right
                elif reader.get(right) > target:
                    break
                left = right
                right *= 2
            except IndexError:
                break

        # Perform binary search within the determined bounds
        while left <= right:
            mid = (left + right) // 2
            try:
                mid_value = reader.get(mid)
            except IndexError:
                right = mid - 1
                continue

            if mid_value == target:
                return mid
            elif mid_value < target:
                left = mid + 1
            else:
                right = mid - 1

        # If the target is not found, return -1
        return -1
