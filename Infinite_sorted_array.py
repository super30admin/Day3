#Time complexity is O(logn) to set the range and O(logn) to search. Total will be O(logn)
#Space complexity is O(1)
#Yes this worked on leetcode.
#I faced a little difficulty at understanding what API interface is but then it went smooth

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        if reader.get(0) == target:
            return 0

        left, right = 0,1
        while reader.get(right) < target:
            left = right
            right = right*2
        while left <=right:
            mid = left + (right-left)//2
            num = reader.get(mid)

            if num == target:
                return mid
            if num>target:
                right = mid-1
            else:
                left = mid+1
        return -1