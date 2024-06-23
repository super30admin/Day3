# Time Complexity: O(logn)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Don't have leetcode premium
# Any problem you faced while coding this: Yes, for the below array, the last index value 666 is target.
# But throwing index out of range error


class SearchInUnknown:

    def Search (self, nums, target):
        low = 0
        high = 1
        # find the range first to do BS
        while target > nums[high] and high:
            low = high
            high = high * 2
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                return mid
            elif target < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        return -1


obj = SearchInUnknown()
arr = [1, 2, 3, 5, 7, 8, 11, 99, 345, 666]
target = 666
print(obj.Search(arr, target))