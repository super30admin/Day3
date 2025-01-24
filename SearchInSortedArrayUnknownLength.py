# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """

"""
Brute force approach - linear search by doing reader.get(index) till we find target
TC - O(n)
SC - O(1)

Binary Search approach -
1. Start with low = 0 and high = 1. Increment the range between low and high by doing high *= 2 till reader.get(high) < target
2. Implement binary search when the above condition is satisfied
TC - O(log n)
SC - O(1)
"""


# class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def binarySearch(self, reader: 'ArrayReader', low: int, high: int, target: int) -> int:
        while low <= high:
            mid = low + (high - low) // 2

            if reader.get(mid) == target: return mid

            # search on left side
            if reader.get(mid) > target:
                high = mid - 1
            # search on right side
            else:
                low = mid + 1
        return -1

    def search(self, reader: 'ArrayReader', target: int) -> int:
        if target is None: return -1

        low = 0
        high = 1

        while reader.get(high) < target:
            low = high
            high = 2 * high

        return self.binarySearch(reader, low, high, target)
