#Problem 1- Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]:
            return False

        rows, cols = len(matrix), len(matrix[0])
        low, high = 0, rows * cols - 1

        while low <= high:
            mid = low + (high - low) // 2
            mid_value = matrix[mid // cols][mid % cols]

            if mid_value == target:
                return True
            elif mid_value < target:
                low = mid + 1
            else:
                high = mid - 1

        return False

#Problem 2-Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]:
            return False

        rows, cols = len(matrix), len(matrix[0])
        low, high = 0, rows * cols - 1

        while low <= high:
            mid = low + (high - low) // 2
            mid_value = matrix[mid // cols][mid % cols]

            if mid_value == target:
                return True
            elif mid_value < target:
                low = mid + 1
            else:
                high = mid - 1

        return False

    def search(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1

        low, high = 0, len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if nums[mid] == target:
                return mid

            # Check which part is sorted
            if nums[low] <= nums[mid]:
                # Left part is sorted
                if nums[low] <= target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                # Right part is sorted
                if nums[mid] < target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1

        return -1

#Problem 3 - Search in Infinite sorted array:https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
class Solution:
    def search(self, reader, target):
        low = 0
        high = 1
        
        while reader.get(high) < target:
            high *= 2
        
        while low <= high:
            mid = (low+high)//2
            
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1