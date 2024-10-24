def binarySearch2(arr, l, m, h, n, target):
    if l <= h and m <= n:
        midx = (l + h) // 2
        midy = (m + n) // 2
    
        if arr[midx][midy] == target:
            return True
        elif arr[midx][midy] < target:
            return binarySearch2(arr, l, midy+1, h, n, target)
        else:
            return binarySearch2(arr, l, m, h, midy-1, target)
    else:
        return False

def binarySearch1(arr, l, m, h, n, target):
    if l <= h and m <= n:
        midx = (l+ h) // 2
        
        if arr[midx][0] == target:
            return True
        elif arr[midx][0] < target and target <= arr[midx][-1]:
            return binarySearch2(arr, midx, 0, midx, len(matrix[0])-1, target)
        elif arr[midx][0] < target:
            return binarySearch1(arr, midx + 1, m, h, n, target)
        else:
            return binarySearch1(arr, l, m, midx - 1, h, target)
    else:
        return False
        

matrix = [[1],[3]]
target = 3

temp = binarySearch1(matrix, 0, 0, len(matrix)-1, len(matrix[0])-1, target)

print(temp)