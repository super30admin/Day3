# Approach : move the high by 2 twice
# time complexity O(log  n)
# space complexity O(1)


class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1
        while (reader.get(high) < target):
            low = high
            high = high * 2
        while (low <= high):
            mid = low + (high - low) // 2   
            #integer overflow, in python there is no overflow it internally changes the datatype int to double int
            val = reader.get(mid)
            if val ==  target:
                return mid
            elif val > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1