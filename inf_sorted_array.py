"""
TC - O(log(N))
SC - O(1)

Approach
Infinite array - set low to 0 and high to 1

Find mid use index to check value against target
If value at mid is greater that target reduce high pointer to mid -1 and search in array part left of mid

If not then search in right part, increase low = mid +1 and continue.

If value at high index is less than target then double high and move low to current high.

This way to move towards right until we can determine section target can lie in using high and mid.
"""


class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1
        while reader.get(high)<target:
            low = high
            high = 2*high
        while low<=high:
            mid = low + (high-low)//2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                high = mid - 1
            else: low = mid + 1
        return -1