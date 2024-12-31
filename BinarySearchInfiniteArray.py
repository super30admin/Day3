# // Time Complexity : O (log (high - low)) where high - low are the number of elements we are performing binary search on 
# // Space Complexity : O (1)
# // Did this code successfully run on Leetcode : No (It is a Premium Problem, I dont have access to it.)
# // Any problem you faced while coding this : NA

# # // Your code here along with comments explaining your approach in three sentences only

class Solution(object):
    # searching in an array of unknown size, given that we can use reader.get(index) to access the value at that index in this private array
    def searchInfiniteArray(self, reader, target):
        # since binary search means that we have to divide the list in any two halves, we are iterating the list with low =  and high = 1
        # because the last index is unknown
        low = 0
        high = 1
        while(reader.get(high) < target):
            # if the value at high index is less than target, we move our high by doubling it 
            low = high + 1
            high = high * 2
        
        # if target is found at high, we will return high
        if target == reader.get(high):
                return high
        
        # else, we have now found the range low to high where the target lies, and we return that range to our binary search function
        return self.binarySearch(reader, target, low, high)
       

    def BinarySearch(reader, target, low, high):
        # binary search iteration
        while(low <= high):
            # computing mid
            mid = high + low // 2
            # if target found at mid, return mid
            if reader.get(mid) == target:
                return mid
            # if target is greater, move right
            elif target > reader.get(mid):
                low = mid + 1
            else:
                # move left
                high = mid - 1
          
        # target not found
        return -1
            
