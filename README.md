# Binary-Search-1


## Problem1 :Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        top = 0
        bot = len(matrix) - 1

        while top <= bot:
            mid = (top + bot) // 2

            if matrix[mid][0] < target and matrix[mid][-1] > target:
                break
            elif matrix[mid][0] > target:
                bot = mid - 1
            else:
                top = mid + 1
        
        row = (top + bot) // 2

        left = 0
        right = len(matrix[row]) - 1

        while left <= right:
            mid = (left + right) // 2

            if matrix[row][mid] == target:
                return True
            elif matrix[row][mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        
        return False

## Problem2 :Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1

        while left <= right:
            mid = (left + right) // 2

            if nums[mid] == target:
                return mid

            # Check if left half is sorted
            if nums[left] <= nums[mid]:
                if nums[left] <= target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            # Otherwise, right half is sorted
            else:
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1

        return -1




## Problem3:Search in Infinite sorted array: https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
class ArrayReader:
    def get(self, index: int) -> int:
        pass  # Placeholder for the get method of ArrayReader.


class Solution:
    def search(self, reader: ArrayReader, target: int) -> int:
        """
        Search for a target value in a sorted array of unknown length.

        We use a binary search approach, defining the initial range based
        on given constraints (here 0 to 20000).

        Parameters:
        reader (ArrayReader) - an instance of ArrayReader to access array elements
        target (int) - the target value to search for

        Returns:
        int: The index of the target value or -1 if the target is not found.
        """
      
        # Initialize the left and right pointers for binary search.
        left, right = 0, 20000
      
        # Perform binary search within the bounds of left and right.
        while left <= right:
            # Calculate the middle index.
            mid = left + (right - left) // 2
            # Retrieve the value at the middle index from the reader interface.
            mid_value = reader.get(mid)
          
            # If the middle value matches the target, return the index.
            if mid_value == target:
                return mid
            # If the middle value is greater than the target, adjust right boundary.
            elif mid_value > target:
                right = mid - 1
            # If the middle value is less than the target, adjust left boundary.
            else:
                left = mid + 1
      
        # If the loop ends and we haven't returned, the target is not in the array.
        return -1

Please note that the ArrayReader class is not fully implemented above.
It only serves a placeholder to illustrate how the get method signature should look.
Since the original problem was rewritten to match Python 3 syntax and best practices,
real implementation of get method from ArrayReader class or real input would be required to run the code.

Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.
