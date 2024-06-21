# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

#time: O(log n)
#space: O(1)
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        r = 1
        while reader.get(r)<target:
            r=r*2
        l=0
        while l<=r:
            m = (l+r)//2
            if target==reader.get(m):
                return m
            elif target>reader.get(m):
                l+=1
            else:
                r-=1
        
        return -1
