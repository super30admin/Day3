class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        start = 0
        end = 1
        while reader.get(end) < target:
            start = end 
            end = end * 2
        return self.binary_search(reader,target,start, end)
    
    def binary_search(self, reader,target,start, end):
        while start <= end:
            mid = start +(end-start)//2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                end = mid-1
            else:
                start = mid+1
        return -1
        
