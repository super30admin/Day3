
#Approach
# First we need to find high index by using iterative increasing the range by twice
# after finding the range bo the binary search

#Complexity
# Time complexity O(log m) +O(log n)
# space Complexity  : O(1) +O(logn) recursive auxilary space

class Solution:

    def Search(self,reader,target):
        low, high =0,1

        while reader.get(high)<target:
            low = high
            high = 2* high
        return self.binarySearch(reader,low,high,target)
    def binarySearch(self,reader, l, r, x):
        mid = int((l + r) / 2)
        if l == r:
            if reader.get(mid) == x:
                return mid
            else:
                return -1
        while r > l:
            if reader.get(mid) == x:
                return mid
            elif reader.get(mid) < x:
                return self.binarySearch(reader, mid + 1, r, x)
            else:
                return self.binarySearch(reader, l, mid - 1, x)
