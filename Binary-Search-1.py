# Binary-Search-1
# Problem1
# Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if matrix == None or len(matrix) == 0:
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
            elif target > matrix[row][col]:
                low = mid + 1
            else:
                high = mid - 1
        return False

# Problem2
# Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if nums == None or len(nums) == 0:
            return -1
        
        n = len(nums)
        low = 0
        high = n - 1

        while low <= high:
            mid = low + (high - low) // 2 # to prevent integer overflow
            if nums[mid] == target:
                return mid
            # Left Sorted
            if nums[low] <= nums[mid]:
                if nums[low] <= target and nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            # Right Sorted
            else:
                if nums[mid] < target and nums[high] >= target:
                    low = mid + 1
                else: 
                    high = mid - 1
        return -1
# Problem3
# Search in Infinite sorted array:
# https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

# Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. 
# If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1
        while reader.get(high) < target:
            low = high
            high = high * 2
        return self.binarySearch(reader, target, low, high)
    
    def binarySearch(self, reader: 'ArrayReader', target: int, low: int, high: int) -> int:
        while low <= high:
            mid = low + (high - low) // 2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1