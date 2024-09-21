# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def linear_search(self, reader: 'ArrayReader', target: int) -> int:
        """
        This is linear search with O(n) time complexity
        :param reader: API
        :param target: target to search in sorted array of unknown size
        :return: True if target exists else false
        """
        idx = 0
        while True:
            el = reader.get(idx)
            if el == target:
                return idx
            if el == pow(2, 31) - 1:
                return -1

            idx += 1

    def binary_search(self, reader, target, lo, hi):
        """
        This method implements binary search
        :param reader: API
        :param target: to search
        :param lo: lower bound for binary search
        :param hi: upper bound for binary search
        :return: index of element in sorted array or -1 if not found
        """
        while lo <= hi:
            mid = lo + (hi - lo) // 2
            el = reader.get(mid)
            if el == target:
                return mid

            elif el < target:
                lo = mid + 1

            elif el > target:
                hi = mid - 1

        return -1

    def binary_search_1(self, reader: 'ArrayReader', target: int) -> int:
        """
        This is binary search with O(log n) time complexity. The upper bound of binary search in this method
        is pow(2,31). What if the array size is 10 then a significant number of iterations will be of no use.
        Thus, its better to find the range in which target may exist. Implemented in binary_search_2() method.
        :param reader: API to get element at index i
        :param target: target to search in sorted array of unknown size
        :return:  idx if target exists else -1
        """
        lo = 0
        hi = pow(2, 31) - 1

        idx = self.binary_search(reader, target, lo, hi)
        return idx

    def binary_search_2(self, reader: 'ArrayReader', target: int) -> int:
        """
        This is binary search with O(log n) time complexity. First we find the range in which the target exists using
        binary search.
        Then use binary search to find the target index.
        :param reader: API to get element at index i
        :param target: target to search in sorted array of unknown size
        :return:  idx if target exists else -1
        """
        lo = 0
        hi = 1

        while target > reader.get(hi):
            lo = 0
            # since hi is multiplied by 2, it is binary search. Meaning search space increases 2 times in each iteration
            # If multiplied by 3 it won't be binary search. TC: O(log base 3 n)
            hi = 2 * hi

        idx = self.binary_search(reader, target, lo, hi)
        return idx
