# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1

        while (low <= high):
            if target <= reader.get(high):
                return self.binarySearch(reader, target, low, high)
            else:
                low = high
                high = low * 2
        return -1

    def binarySearch(self, reader: 'ArrayReader', target: int, low: int, high: int) -> int:
        while (low <= high):
            print(low, high)
            mid = low + (high - low) // 2
            print(mid)
            if reader.get(mid) == target:
                return mid
            if reader.get(mid) <= target:
                low = mid + 1
            else:
                high = mid - 1
        return -1

