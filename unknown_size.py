# The code implements a search algorithm for an unknown-sized, sorted array using an external interface 'ArrayReader'.
# The search method utilizes binary search to efficiently locate the target value within the array.
# An initial left (l) and right (r) boundary is set, where:
#   - 'l' starts at index 0.
#   - 'r' is obtained through reader.get(-1), which is assumed to return the size or a boundary of the array.
# In each iteration, the mid-point (mid) is calculated to split the search space:
#   - If reader.get(mid) equals the target, mid is returned as the index where the target is found.
#   - If reader.get(mid) is greater than the target, the search shifts to the left half by setting r = mid - 1.
#   - Otherwise, it shifts to the right half by setting l = mid + 1.
# If the target is not found after the loop, -1 is returned, indicating the target does not exist in the array.
# 
# TC: O(log n) - Since binary search reduces the search space by half each iteration.
# SC: O(1) - Constant space is used, as only pointers for the search range and mid-point are maintained.


class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int: # type: ignore
        l, r = 0, reader.get(-1)
        print(r)
        while l <= r:
            mid = (l + r) // 2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                r = mid - 1
            else:
                l = mid + 1
        return -1
        