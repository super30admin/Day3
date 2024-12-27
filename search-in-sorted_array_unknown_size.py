#Time Complexity :- O(logp) - p is position of target in infinite array
# Space Complexity :- O(1)
# Leetcode - yes
# Approach -  starting with small range [low =0  an high = 1] if target is greater than high we will move our high pointer by double and low will take place of previous high
# then we will perform binary search in that range and return the found element

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
        return self.binarysearch(reader,target,low,high)

    def binarysearch(self,reader: 'ArrayReader',target:int,low:int,high:int):
        while low <= high:
            mid = low + (high - low) // 2
            mid_val = reader.get(mid)
            if (mid_val == target):
                return mid
            elif mid_val > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1