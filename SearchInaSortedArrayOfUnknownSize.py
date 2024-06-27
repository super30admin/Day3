#The search method in the Solution class implements a binary search algorithm to find the index of a target integer t within an ArrayReader object. It initializes l (left) to 0 and r (right) to 10,000, setting up an initial search range. Within a while loop that runs while l is less than or equal to r, it calculates the middle index mid and retrieves the value at that index using reader.get(mid). Depending on whether the retrieved value val is equal to, less than, or greater than t, the search range is adjusted accordingly. This process repeats until l surpasses r, indicating that t is not present in the array, at which point the method returns -1. The algorithm operates with O(log n) time complexity, efficiently narrowing down the search space with each iteration, and uses O(1) additional space, maintaining only a few variables throughout the search.

class Solution:
    def search(self, reader: 'ArrayReader', t: int) -> int:
        l , r = 0, 10**4
        while l <= r:
            mid = l + (r - l) // 2
            val = reader.get(mid)
            if val == t:
                return mid
            elif val < t:
                l = mid + 1
            else:
                r = mid - 1
        return -1