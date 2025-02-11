#t.c = O(log N)
#s.c  = O(N)
class Solution(object):
    def search(self, reader, target):
        """
        :type reader: List[int] (Infinite sorted array with reader.get(index) method)
        :type target: int
        :rtype: int
        """

        low, high = 0, 1
        while reader.get(high) < target:
            low = high
            high *= 2  

        while low <= high:
            mid = low + (high - low) // 2
            val = reader.get(mid)

            if val == target:
                return mid
            elif val > target:
                high = mid - 1
            else:
                low = mid + 1
        
        return -1
