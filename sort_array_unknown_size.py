# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader(object):
#    def get(self, index):
#        """
#        :type index: int
#        :rtype int
#        """


class Solution(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        # since array is of unkonwn size we set high to 1 and increment it by 2
        low = 0
        high = 1

        # comparing the target to what is read from api at position high
        while reader.get(high) < target:
            low = high
            high = 2 * high
        while low <= high:
            mid = low + (high - low) // 2
            value = reader.get(mid)

            if value == target:
                return mid
            elif value < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1


# amortized time complexity is O(logk) because we dont know how many elements we need since array size is unknown
# amortized space complexity is O(1) because only constant amount of extra space is needed
