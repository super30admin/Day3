#Time and Space Complexity O(log n)
class Solution:
    def binarysearch(self, arr, low, high, target):
        while low <= high:
            mid = (low + high) // 2
            if arr[mid] == target:
                return mid
            elif arr[mid] < target:
                return self.binarysearch(arr, mid+1, high, target)
            elif arr[mid] > target:
                return self.binarysearch(arr, low, mid, target)
            
            
    def search(self, arr, target: int) -> int:
        # Your code here
        low = 0
        high = 1
        
        while True:
            try:
                if arr[high] >= target:
                    break
                high *= 2
            except IndexError:  # Catches out of bounds exception
                break
        low = high // 2
        high = min(high, len(arr)-1)
        position = self.binarysearch(arr, low, high, target)
        print("Target ", target, "is at", position)
        return position
            
        
        
sample_arr = [1, 3, 5, 7, 9, 13, 17, 21, 25, 27, 29, 32, 34, 36, 37, 39, 40, 43, 47, 49, 51, 52, 53, 57, 62, 64, 66, 71, 81]
target = 71
s_ia = Solution()
s_ia.search(sample_arr, 1) # At 0
s_ia.search(sample_arr, 37) # At 14
s_ia.search(sample_arr, 81) # At 28
