## Problem 3 : Search in Infinite sorted array:
##https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
# Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
# Time Complexity : log(n) + log(n) (maybe?)
# Space Complexity : O(1) No extra space created
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : wasn't able to start, checked a hint online for using exponential range


# this uses a (static array + no use of len function) to simulate the problem restrictions.
# Tried to find candidate list by checking between exponentially increasing range
# should have implemented a try except for elgant handling of out of range

def search(reader, target):
    i = 0
    while i <= 3:
        if reader[i] == target:
            return i
        if reader[i] > target:
            return -1
        i+=1
    c = 2    
    while i <= ((2**10)-1) and reader[i] <target:
        j = i
        i = 2**c
        c += 1
       
    if reader[i] == target:
        return i
    x = binarySearch(reader[j:i], target)
    if x != -1:
        return x+j
    return -1
def binarySearch( arr, target):
    low, high = 0 , len(arr)-1
    while low <= high:
        mid  = low + (high - low)//2
        if arr[mid] == target:
            return mid
        elif arr[mid] <=target:
            low = mid+1
        else:
            high = mid - 1
    
    return -1
a = [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65]
key = 9
print(search(a,key))
