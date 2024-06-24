# Time complexity: O(logn)
# Space complexity: O(1)
class Solution:
    def search(self, reader: ArrayReader, target: int) -> int:
      
        left, right = 0, 1
        # find the right boundary
        while reader.get(right) < target:
            left = right
            right *= 2

        while left <= right:
            mid = left + (right - left) // 2
            mid_value = reader.get(mid)
          
            if mid_value == target:
                return mid
            elif mid_value > target:
                right = mid - 1
            else:
                left = mid + 1
      
        return -1