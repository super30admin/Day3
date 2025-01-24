"""
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes. (#702)
// Any problem you faced while coding this : No.
"""

'''
created a simple ArrayReader Class
'''
class ArrayReader:
   def __init__(self,arr):
       self.arr = arr
       self.maxValue = 2**31 - 1

   def get(self, index: int) -> int:
        try:
           return self.arr[index]
        except IndexError:
            return self.maxValue
    
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low  = 0
        high = 1
        while reader.get(high) < target:
            low  = high
            high *=2
        while low <= high:
            mid = (low + high) // 2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1
    
ArrayReaderObj = ArrayReader([1,2,3,4,5,6,20,40,90,220])
SolutionObj = Solution()
print("found index", SolutionObj.search(ArrayReaderObj,6))