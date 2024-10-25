class Solution:
    def search(self, reader, target):
        if reader.get(0) == target:
            return 0

        # search boundaries
        l, r = 0, 1
        while reader.get(r) < target:
            l = r
            r = r * 2

        # binary search
        while l <= r:
            mid = l + ((r - l) // 2)
            num = reader.get(mid)

            if num == target:
                return mid
            if num > target:
                r = mid - 1
            else:
                l = mid + 1

        # there is no target element
        return -1