# Time Complexity : O(log T = log n), where T is index of target, maximum value of T is n
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# My approach: find the start and end where the target will be present by jumping 2x every time to an index until its value is just greater than target
# and start will be assigned to end // 2. then doing binary search in between start and end


# finding end such that secret[end] is just > target
end = 1
while reader.get(end) < target:
    end *= 2
if reader.get(end) == target:
    return end
    
# binary search
start = end // 2
while start <= end:
    mid = start + ((end - start) // 2)
    midval = reader.get(mid)
    if midval == target:
        return mid
    elif midval < target:
        start = mid + 1
    else:
        end = mid - 1

return -1