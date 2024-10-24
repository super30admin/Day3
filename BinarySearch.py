def binarySearch(arr, l , h, target):
    if l <= h:
        mid = (l+ h) // 2
        
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            return binarySearch(arr, mid + 1, h, target)
        else:
            return binarySearch(arr, l, mid - 1, target)
    else:
        return False
        

arr = [1, 3, 5, 7, 9, 11, 13, 15]
target = 12

temp = binarySearch(arr, 0, len(arr)-1, target)

print(temp)