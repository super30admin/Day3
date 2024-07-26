def search_in_unknown_size_array(arr, target):
    low, high = 0, 1
    while target > arr[low] and target > arr[high]:
        low = high
        high *= 2
    # now you got low and high in which target will lie
    while low <= high:
        mid = low + (high-low)/2
        if target == arr[mid]:
            return mid
        elif target < arr[mid]:
            high = mid - 1
        else:
            high = mid + 1
    return -1

    