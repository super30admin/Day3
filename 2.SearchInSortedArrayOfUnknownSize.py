# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

"""
Time Complexity: 0(log n)
Space Complexity: 0(1)
Approach: Perform binary serach in reverse
"""

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:

        low = 0
        high = 1

        while low <= high:
            mid = (high-low)//2 + low

            if reader.get(mid) == target:
                return mid

            elif reader.get(mid) < target:
                # tgt on rhs
                low = mid + 1
                high = high * 2

            elif reader.get(mid) > target:
                # tgt on lhs
                high = mid - 1
        
        # end of while loop

        return - 1 