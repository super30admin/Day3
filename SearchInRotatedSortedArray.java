class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
int arrayLength = nums.length;
if(arrayLength==0 || nums==null){
    return -1;
}
        int low=0;
        int high=arrayLength-1;
        while(low<=high)
        {   int mid =low +(high-low)/2;
             if(nums[mid] == target)
            return mid;
            else if(nums[low]<=nums[mid]){
            if(nums[low]<=target && nums[mid]>target)
            {
                high=mid-1;
            }
            else{
                low=mid+1;
            }
            }
            else{
                if(nums[mid] < target && nums[high]>=target)
                {
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}


//Time Complexity: O(log n)
//Space Complexity: O(1)