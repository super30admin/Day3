/**
 * Algo:
 * In a rotated Array find mid. Then once side of the array is sorted and the other side is not sorted.
 * Required Time Complexity -->O(log(n))
 * - get the side of the sorted. if element present within the range, move the low and high accordingly.
 * - else move the low or right to the other side right next to mid. now new sub array will have 2  halves which one is sorted and the other is un sorted
 *
 * Time Complexity -->O(log(n))
 * Space Complexity -->O(1)
 *
 */
class SearchRotatedArray {
    public int search(int[] nums, int target) {
        int low =0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low +(high -low)/2; // using this insted of (high+low)/2 to avoid integer overflow
            if(nums[mid]==target){
                return mid;
            }else if(nums[low]<=nums[mid]){
                if(target>=nums[low] && target<nums[mid]){
                    high = mid-1;
                }else{
                    low = mid +1;
                }
            }else{
                if(target>nums[mid] && target<=nums[high]){
                    low = mid +1;
                }else{
                    high = mid -1;
                }
            }
        }
        return -1;
    }
}