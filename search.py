# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this :No 

def search(reader, target):
    """
    :type reader: ArrayReader
    :type target: int
    :rtype: int
    """
    left, right = 0, 1
    # Expand the right boundary until the target is within the range
    while reader.get(right) < target:
        left = right
        right *= 2
    
    # Binary search within the identified range
    while left <= right:
        mid = (left + right) // 2
        if reader.get(mid) == target:
            return mid
        elif reader.get(mid) < target:
            left = mid + 1
        else:
            right = mid - 1
    return -1
