def search_in_unknown_length_array(arr, target):
    # Check the 0th index to see if it is out of bounds or matches the target
    try:
        if arr[0] == target:
            return 0
    except IndexError:
        return -1
    
    # Find the range where the target might be located
    index = 1
    while True:
        try:
            if arr[index] == target:
                return index
            elif arr[index] > target:
                break
            index *= 2
        except IndexError:
            break

    # Perform binary search within the determined range
    left, right = index // 2, index
    while left <= right:
        mid = (left + right) // 2
        try:
            if arr[mid] == target:
                return mid
            elif arr[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        except IndexError:
            right = mid - 1
    
    return -1

# Example usage:
class ArrayReader:
    def __init__(self, arr):
        self.arr = arr
    
    def __getitem__(self, index):
        if index < 0 or index >= len(self.arr):
            raise IndexError
        return self.arr[index]

arr = ArrayReader([1, 2, 4, 5, 6, 8, 10, 12, 14])
target = 5
index = search_in_unknown_length_array(arr, target)
print(f"Index of {target}: {index}")