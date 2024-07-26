# time complexity O(log  n)
# space complexity O(1)
# tested on leetcode
# uses the 
# Using binary search to find the value of high till we find the range for the target
#  

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1
        while (reader.get(high) < target):
            low = high
            high = high * 2
        print(high)
        while (low <= high):
            mid = low + (high - low) // 2   # takes care of interger overflow, in python there is no overflow it internally changes the datatype to float
            val = reader.get(mid)
            if val ==  target:
                return mid
            elif val > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

