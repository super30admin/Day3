# Time complexity: O(log n)
# Space complexity: O(n)

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1

        while reader.get(high) < target:
            low = high
            high = high * 2
            
        index = -1
        while low <= high:
            mid = low + (high - low) // 2
            if reader.get(mid) == target:
                index = mid
                break
            if target < reader.get(mid):
                high = mid - 1
            elif reader.get(mid) < target:
                low = mid + 1
        return index
