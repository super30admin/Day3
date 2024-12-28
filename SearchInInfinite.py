# This is the ArrayReader's API interface.
# You should not implement it, or speculate about its implementation.
# class ArrayReader:
#     def get(self, index: int) -> int:
#         pass

# Had to google and read few solutions 
# TC - O(logn)
# Sc - O(1)


OUT_OF_BOUND = 2147483647

class Solution:
    def search(self, reader, target: int) -> int:
        lo = 0
        hi = 2**31 - 1  # Equivalent to Integer.MAX_VALUE
        
        while lo <= hi:
            mid = (lo + hi) // 2
            
            midVal = reader.get(mid)
            
            if midVal == target:
                return mid
            
            if midVal == OUT_OF_BOUND or midVal > target:
                hi = mid - 1
            else:
                lo = mid + 1
                
        return -1
