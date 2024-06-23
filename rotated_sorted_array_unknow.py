"""
Time Compexity: O(logn)
Sace Complexity: O(1)
"""

class Solution:
    def search(self, reader, target):

        low = 0
        high = 1
        
        while reader.get(high) < target:
            low = high
            high = 2*high
            
        while low <= high:
            mid = low + (high - low) // 2
            mid_val = reader.get(mid)
            if mid_val == target:
                return mid
            elif mid_val < target:
                low = mid + 1
            

            else:
                high = mid - 1

        return -1