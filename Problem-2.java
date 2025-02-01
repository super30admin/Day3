class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        if (nums.length == 0)
            return -1;

        while (low < high) {
            int midIndex = low + (high - low) / 2;
            if (nums[midIndex] == target) {
                return midIndex;
            }
            if (nums[low] <= nums[midIndex]) {
                if ((target < nums[midIndex]) && (target >= nums[low])) {
                    high = midIndex - 1;
                } else {
                    low = midIndex + 1;
                }
            } else if (nums[midIndex] < nums[high]) {

                if ((target > nums[midIndex]) && (target <= nums[high])) {
                    low = midIndex + 1;
                } else {
                    high = midIndex;
                }

            }

        }
        int index = (nums[high] == target) ? high : -1;
        return index;
    }
}
