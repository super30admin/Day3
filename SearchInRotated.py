# Time Complexity: O(logn)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class SearchInRotated:

    def Search(self, arr, target):
        low = 0
        high = len(arr)-1
        while low <= high:
            mid = low + (high-low)//2
            if arr[mid] == target:
                return mid
            # left is sorted, check if target is in this range. then move high to mid-1
            elif arr[low] <= arr[mid]:
                if arr[low] <= target < arr[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if arr[mid] < target <= arr[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1


obj = SearchInRotated()
arr = [3, 1]
target = 3
print(obj.Search(arr, target))