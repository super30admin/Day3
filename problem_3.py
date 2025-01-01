"""
Problem 3: Search in a Sorted Array of Unknown Size (702. Search in a Sorted Array of Unknown Size)
Time Complexity: O(log n)
Space Complexity: O(1)
The code uses a binary search approach to find the target element in the given list.
It starts with a low index of 0 and a high index of 1, and keeps doubling the high index until the target element is less than the value at the high index.
Once the high index is found, the code performs a binary search between the low and high indices to find the target element.
The binary search reduces the search interval to half in each iteration, leading to a time complexity of O(log n).
"""


class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1
        while reader.get(high) < target:
            low = high
            high = high * 2

        if reader.get(high) == target:
            return high

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