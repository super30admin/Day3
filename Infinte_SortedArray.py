
# Time Complexity : O(log n), where n is the length of the array
# Space Complexity : O(1), as no extra space is used apart from a few variables
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#     def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        # Step 1: Find the range where the target could exist
        left, right = 0, 1
        
        # Expand the search space exponentially until the target is within range or we hit the boundary
        while reader.get(right) < target and reader.get(right) != 2**31 - 1:
            left = right
            right *= 2  # Double the right boundary
        
        # Step 2: Perform binary search within the identified range
        while left <= right:
            mid = (left + right) // 2
            mid_element = reader.get(mid)

            # Check if the mid element is the target
            if mid_element == target:
                return mid
            elif mid_element > target or mid_element == 2**31 - 1:
                right = mid - 1  # Search in the left half
            else:
                left = mid + 1  # Search in the right half

        # If the target is not found, return -1
        return -1
