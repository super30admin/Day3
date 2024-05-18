# Time Complexity
# O(log n)
# Space Complexity
# O(1)

# Approach :

# Since the upper bound of array isnt known and to maintain O(log n) complexity,
# we set l=0 and high =1 and increment h as h*=2 and make l=h, till the target is greater than h, once smaller we have found the upper bound.
# After find low and high, calculate mid point of the reader interface, and perform binary search till the element is met, else return -1


class Solution:
    def search(self, reader, target):

        low = 0
        high = 1

        while reader.get(high) < target:
            low = high
            high = high * 2

        return self.binarySearch(reader, low, high, target)

    def binarySearch(self, reader, low, high, target):

        while (low <= high):
            mid = (low + high) // 2
            if (reader.get(mid) == target):
                return mid

            if (target > reader.get(mid)):
                low = mid+1

            else:
                high = mid-1

        return -1
