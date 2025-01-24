class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        minval    = reader.get(0)
        if target < minval: return -1
        left  = 0
        right = target - minval
        while left <= right:
            mid = (left + right) // 2
            midval = reader.get(mid)
            if midval > target:
                right = mid - 1
            elif midval < target:
                left  = mid + 1
            else: 
                return mid
        return -1