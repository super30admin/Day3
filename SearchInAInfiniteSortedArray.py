# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        left = 0
        right = 1
        while reader.get(right) < target:
          left = right
          right = 2* right

        return self.binary_search(reader, left, right, target)

    def binary_search(self, reader:'ArrayReader', low: int, high:int, target: int) -> int:
      while low <= high:
        mid = low + (high-low)//2

        if reader.get(mid) == target:
          return mid
        elif reader.get(mid) > target:
          high = mid -1
        else:
          low = mid + 1
      
      return -1