# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        if reader.get(0)==target:
            return 0

        l=0
        h=1

        while reader.get(h)<target:
            l= h
            h= h*2
        return self.binary_search(reader, target, l, h)

    def binary_search(self,reader, target,low,high):
        while(low<=high):
            mid = (low + high)//2
            if reader.get(mid)==target:
                return mid
            elif reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1
    
#TC : O(log N)
#SC : O(1)
        
        

        