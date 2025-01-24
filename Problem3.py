# Search in Infinite sorted array: https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

# Time Complexity: O(log(n))
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach:
# Use binary search to find the target in an infinite sorted array.
# Adjust the search range based on comparisons to determine which half contains the target.
# Continue narrowing down the search until the target is found or the range is exhausted.

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low,high = 0,1
        while reader.get(high) < target:
            low = high
            high = 2*high
        while low <= high:
            mid = (low + high) // 2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1