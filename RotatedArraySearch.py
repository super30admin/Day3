def binarySearch(nums, target, l, h):
    if l<=h :
        mid = (l + h)//2
    
        if nums[mid] == target:
            return mid
        if nums[l] <= nums[mid]:
            if target >= nums[l] and target<nums[mid]:
                return binarySearch(nums, target, l, mid-1)
            else:
                return binarySearch(nums, target, mid+1, h)
        else:
            if target <= nums[h] and target > nums[mid]:
                return binarySearch(nums, target, mid+1, h)
            else:
                return binarySearch(nums, target, l, mid-1)
    else: 
        return -1
        
        
        
        
    #     if nums[mid] < target and target >= nums[h]:
    #         return binarySearch(nums, target, mid+1, h)
    #     if nums[mid] > target and target <= nums[l]:
    #         return binarySearch(nums, target, l, mid-1)
    #     if nums[mid] > target and target <= nums[h]:
    #         return binarySearch(nums, target, mid+1, h)
    #     if nums[mid] < target and target >= nums[l]:
    #         return binarySearch(nums, target, l, mid-1)
    #     if nums[mid] < target and target <= nums[h]:
    #         return binarySearch(nums, target, mid+1, h)
    #     if nums[mid] > target and target >= nums[l]:
    #         return binarySearch(nums, target, l, mid-1)
    #else:
        #return -1


def search(nums, target) -> int:
    return binarySearch(nums, target, 0, len(nums)-1)
    
        
        
        
nums = [4,5,6,7,0,1,2]
target = 0
index = search(nums, target)

print(index)




