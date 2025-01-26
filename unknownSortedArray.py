""" Time Complexity : O(log n)
 Space Complexity : O(1)
 Did this code successfully run on Leetcode : Yes """
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1

        while reader.get(high) < target:
            low = high
            high = 2 * high
        
        while low <= high:
            mid = low + (high - low) // 2
            if reader.get(mid) == target:
                return mid
            if reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1