class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1
        while reader.get(high) < target:
            low = high
            high = 2 * high

        while low <= high:
            mid = (low + high)//2
            number = reader.get(mid)
            if number == target:
                return mid
            elif number > target:
                high = mid - 1
            else:
                low = mid + 1

        return -1
