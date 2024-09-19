'''
    Time Complexity: O(logn)
    Space Complexity: O(1)
    Ran successfully on leetcode
    Difficulty: Solved quickly by implementing simple Binary search and handling the out of bounds situation
'''

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low, high = 0, 10000

        while low <= high:
            mid = (low + high) // 2
            midValue = reader.get(mid)

            if target == midValue:
                return mid
            elif target < midValue or midValue == 2147483647:
                high = mid - 1
            else:
                low = mid + 1

        return -1