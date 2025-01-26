# Time Complexity : O(logn) - where n is the index of the target in array, worst case t can be n
# Space Complexity : O(1)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

"""
Firstly find the first and last index between which target will be present
 Set low to 0, high to 1 and keep on moving high by 2x until target > elemnt at high
Secondly run binary search for elements from low to high
"""

def binarySearch(reader, target, low, high):
    while low <= high:
        mid = low + (high - low) // 2
        if target == reader.get(mid):
            return mid
        elif target > reader.get(mid):
            low = mid + 1
        else:
            high = mid - 1

    return -1


def search(reader, target):
    """
    :type reader: ArrayReader
    :type target: int
    :rtype: int
    """

    low = 0
    high = 1

    # if target is less than first element, then no need to check further
    if target < reader.get(0):
        return -1

    # find the low and high
    while reader.get(high) < target:
        low = high
        high = high * 2

    # run binary search from low to high
    return binarySearch(reader, target, low, high)

print(search([-1,0,3,5,9,12],9))
