# // Time Complexity : O(log(n))
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

#  We know that array is sorted.
#  Initialize : l=0 and h = 1, while target not in range (l,h); l = h , h = h*2
#  Then we will use binary search for newly found range
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
            high = high*2
        
        while low <= high:                  # as soon as range is found, we know l and h
            mid = low + (high-low)//2       # we need a pivot point to find the target
            if reader.get(mid)== target:    # binary search
                return mid
            elif reader.get(mid)< target:
                low = mid + 1
            else:
                high = mid -1
        return -1