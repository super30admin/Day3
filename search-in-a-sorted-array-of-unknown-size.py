
# Explanation:
# Double the high index until the target is within range (reader.get(high) >= target).
# Perform binary search between low and high to find the target.
# Time:O(logT+logN), where T is the target's index and  N is the total number of elements.
# Space: O(1), as no extra space is used.
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1
        while reader.get(high) < target:
            low = high
            high *= 2

        while low <= high:
            mid = (low + high) // 2
            value = reader.get(mid)

            if value == target:
                return mid
            elif value > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1