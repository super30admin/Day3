
#Time complexity: O(logn) + O(logk) log k - binary search to find the range , logn  the target search 
#Space complexity : O(1)
# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        l, h = 0, 1
        while reader.get(h) < target:
            l = h
            h = 2*h
        while l <= h:
            mid = (l+h)//2
            if reader.get(mid) == target:
                return mid
            if reader.get(mid)<target:
                l = mid+1
            else:
                h = mid - 1
        return -1
