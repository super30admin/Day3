public class Problem2 {
    public int search(int[] nums, int target) {

        int n = nums.length;
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(target == nums[mid]){
                return mid;
            }

            if(nums[low] <= nums[mid]){ //left subarray is the sorted
                if(nums[low] <= target && target < nums[mid]){ //target is within left subarray
                    high = mid - 1;
                }else{
                    low = mid + 1;              //target is not present in left subarray
                }
            }else if(nums[high] >= nums[mid]){ //right subarray is the sorted
                if(nums[high] >= target && target > nums[mid]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }

        }return -1;
    }
}

/*Time Complexity -> log(n)
 Space: Complexity -> O(1) */