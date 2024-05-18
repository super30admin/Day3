class RotatedArraySearch {
    public int search(int[] nums, int target) {
        //TC - O(log n), SC- O(1)
        //Using binary search

        //base condition check
        if(nums == null || nums.length == 0)
            return -1;

        int n = nums.length;
        int low = 0;
        int high = n-1;

        while(low <= high) {
            //calculate mid
            int mid = low + (high - low)/2;

            //if target == nums[mid], return mid
            if(target == nums[mid])
                return mid;

            //if left half is sorted, check if target belongs to left half
            if(nums[low] <= nums[mid]) {
                if(target >= nums[low] && target < nums[mid])
                    high = mid -1;
                else
                    low = mid +1;
            }

            //right half is sorted, check if target belongs to right half
            else {
                if(target > nums[mid] && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid -1;
            }
        }

        return -1;

    }
}