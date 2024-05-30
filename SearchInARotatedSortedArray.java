//Time - O(log n), Space - O(1)
public class SearchInARotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0) return -1;

        int left = 0, right = nums.length-1;

        while(left<=right){
            int mid = left + ((right-left)/2);
            if(nums[mid]==target){
                return mid;
            }else if(nums[left]<=nums[mid]){ //check if left side is sorted
                if(nums[left]<=target && target<=nums[mid]){
                    right = mid-1;
                } else{
                    left = mid+1;
                }
            } else{ //right side is sorted
                if(nums[mid]<target && target<=nums[right]){
                    left = mid+1;
                } else{
                    right = mid-1;
                }
            }
        }

        return -1;
    }
}