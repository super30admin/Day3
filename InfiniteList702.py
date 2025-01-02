from typing import List

# Time Complexity : 0(logn)
# Space Complexity : 0(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class ArrayReader:
    def __init__(self, array: List[int]):
        self.array = array
    
    def get(self, index: int) -> int:
        if index >= len(self.array):
            return float('inf')  # Simulates out-of-bound behavior
        return self.array[index]

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1
        while reader.get(high) < target:
            low = high
            high = high*2
        if reader.get(high) == target:
            return high
        return self.binarySearch(reader, target, low, high)

    def binarySearch(self,reader, target, low, high):
        while low <= high:
            mid = low + ((high - low)//2)
            if reader.get(mid) == target:
                return mid
            if target > reader.get(mid):
                low = mid +1
            else:
                high = mid -1
        return -1
        
# Test case
if __name__ == "__main__":
    array = [-1, 0, 3, 5, 9, 12]
    target = 9

    reader = ArrayReader(array)
    solution = Solution()
    result = solution.search(reader, target)
    print(f"Target found at index: {result}")