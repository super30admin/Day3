// Time Complexity : O(log k) + O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Since this is a premium problem, I'm unable to check the execution of the code
// Any problem you faced while coding this : no major difficulties, took little time in figuring out the conditions


// Your code here along with comments explaining your approach in three sentences only

class ArrayReader:
    def get(self, index: int) -> int:
        pass  # Placeholder for the get method of ArrayReader.


class Solution:
    def search(self, reader: ArrayReader, target: int) -> int:
        low = 0
        high = 1

        while reader.get(high) < target and reader.get(high) != 2**31 - 1: # checking if the target element is greater than the high pointer and high does not exceed the maximum integer possible
            low = high # moving the low to the high pointer position
            high = 2 * high # incrementing the high pointer 2x times

        while low <= high:
            mid = (low + high) // 2 # calculating mid

            if reader.get(mid) == target: # if mid equals target, it returns the mid index
                return mid

            if reader.get(mid) > target or reader.get(mid) == 2**31 - 1: # checking if the mid is greater than the target value
                high = mid - 1 # if true, then the high will go to (mid-1)th position

            else:
                low = mid + 1 # else low will go to the next position after the mid

        return -1 # if no target value found, then it will return -1
