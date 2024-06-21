# // Time Complexity : O(log(m) + log(n))

# // Space Complexity : O(1)

# // Did this code successfully run on Leetcode : Yes

# // Any problem you faced while coding this : There were a lot of syntax errors since, 
# // I am using c++ after a very long time
# // Since I am building on top of the class lecture the logic worked out fine


# // Your code here along with comments explaining your approach in three sentences only
# // Using binary search base logic, Since we do not know the length of the array
# // We double at every check to see if the target is in the range and once 
# // we find the range then we apply binary search on the range 

class ArrayReader:
    def __init__(self) -> None:
        self.max = 2000

    def get(self, index: int) -> int:
        if index < self.max:return index
        return 2**31 - 1

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        l = 0
        h = 1
        while target >= reader.get(h):
            l = h
            h = h*2
        
        while l <=h:
            mid = l + (h - l)//2
            num = reader.get(mid)
            if num == target: return mid
            else:
                if num > target: h = mid - 1
                else: l = mid + 1
        return -1

if __name__ == "__main__":
    row = 3
    array_reader = ArrayReader()
    
    sol = Solution()
    res = sol.search(array_reader, 6)
    print(f"True case result: {res}")

    res = sol.search(array_reader, 4000)
    print(f"False case result: {res}")