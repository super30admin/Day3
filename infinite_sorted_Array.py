# space complexity: O(n)
# time complexity: O(log(n))

class ArrayReader:
    def __init__(self, arr):
        self.arr = arr

    def get(self, index: int) -> int:
        if index < 0 or index >= len(self.arr):
            return 2**31 - 1  # Simulate out-of-bounds
        return self.arr[index]

class Solution:
    def search(self, reader: ArrayReader, target: int) -> int:
        low=0
        high = low +1
        while (target > reader.get(high)):
            low= high +1
            high = high * 2

        while (low <= high):
            mid = low + (high-low)//2
            if (reader.get(mid) == target):
                return mid
            elif (reader.get(mid) > target):
                high = mid -1
            else:
                low= mid +1
                
                
                
            
            
            
            
sorted_array = [-1, 0, 3, 5, 9, 12]
target = 9

reader = ArrayReader(sorted_array)

solution = Solution()

result = solution.search(reader, target)

print(f"Index of target {target}: {result}")
