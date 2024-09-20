'''
    Time Complexity: O(logn)
    Space Complexity: O(1)
    Ran successfully on leetcode
    Difficulty: Solved quickly by implementing simple Binary search and handling the out of bounds situation, 
    updated the code by using binary search for getting the range as well
'''

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low, high = 0, 1

        while reader.get(high) < target:
            low = high
            high = 2*high

        while low <= high:
            mid = (low + high) // 2
            midValue = reader.get(mid)

            if target == midValue:
                return mid
            elif target < midValue:
                high = mid - 1
            else:
                low = mid + 1

        return -1