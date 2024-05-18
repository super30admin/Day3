# Time Complexity
# O(log n)
# Space Complexity
# O(1)


# Approach :

# When a sorted array is rotated, on dividing it in 2 parts, at least one side is sorted
# first we search the target element in the sorted part of the array, if not found we move to the other part
# on both the parts we perform binary search, but preference is always to search first from the sorted side

class Solution:
    def search(self, arr: List[int], target: int) -> int:

        if not arr:
            return -1

        high = len(arr)-1
        low = 0

        while (low <= high):
            mid = (high+low) // 2

            if (arr[mid] == target):
                return mid

            if (arr[low] <= arr[mid]):
                if (target >= arr[low] and target < arr[mid]):
                    high = mid-1
                else:
                    low = mid + 1
            else:
                if (target > arr[mid] and target <= arr[high]):
                    low = mid+1
                else:
                    high = mid-1

        return -1
