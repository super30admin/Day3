
# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader(object):
#    def get(self, index):
#        """
#        :type index: int
#        :rtype int
#        """


#TC: O(log n) + O(log n) = O(log n)
# Finding the upper bound will take O(log n) because the search range grows exponentially and then we have to perform a binary search which also takes O(log n)
#SC: O(1)

class Solution(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        low = 0
        high = 1

        #Find upper bound
        while reader.get(high) < target:
            low = high 
            high *= 2 #Exponentially expand the search range
        
        #Perform the binary search
        while low<= high:
            mid = (low+high)//2
            val = reader.get(mid)

            if val == target:
                return mid
            #If mid is out of bounds, shrink the search space
            elif val > target or val == 2**31-1:
                high = mid - 1
            else:
                low = mid + 1
        return -1
        
