# Binary-Search-1


## Problem1 
Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)


class Solution:
    def search(self, nums, target):
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target:
                return True
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return False

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        """
        Searches for the target in a sorted 2D matrix using your logic.
        """
        l, r = 0, len(matrix) - 1
        while l <= r:
            mid = (l + r) // 2
            if target <= matrix[mid][-1]:
                if self.search(matrix[mid], target):
                    return True
                r = mid - 1
            elif target >= matrix[mid][-1]:
                l = mid + 1
        return False

## Problem2 
Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high= len(nums)-1
        while(low<=high):
            mid=(low+high)//2
            if(nums[mid]==target):
                return mid
            elif(nums[mid]>=nums[low]):
                if(target>=nums[low] and target<nums[mid]):
                    high = mid-1
                else:
                    low = mid +1
            else:
                if(target > nums[mid] and target <= nums[high]):
                    low =mid+1
                else:
                    high = mid-1
        return -1

## Problem3
Search in Infinite sorted array: 

https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.

class Solutions:
    def binarySearch(self,l,h,arr,target):
        while(l<=h):
            mid=(l+h)//2
            if arr[mid]==target:
                return mid
            elif target<arr[mid]:
                h = mid-1
            else:
               l =mid+1
        return -1

    def undefiniteArray(self,arr,target):
         low = 0
         high = 1
         while(arr[low]<=target):
             ind = self.binarySearch(low,high,arr,target)
             if (ind == -1):
                 low = high
                 high = 2 * high
             else:
                  return ind
         return -1



if __name__ == '__main__':
    ascending_numbers = list(range(1, 1001))
    target = 100
    s = Solutions()
    k = s.undefiniteArray(ascending_numbers,target)
    print(k)


