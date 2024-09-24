// We would be considering the fact that the rotated sorted array would be having atleast one sorted part and this could be used as a factor to identify to go in which subpart of the array.
// Binary search is used to search the element in the rotated sorted array and the time complexity would be O(logn) and space complexity would be O(1).



public class SearchInRotatedSortedArray {
    
    public int search(int[] nums, int target) {
        int l =0, h = nums.length-1;
        int mid;
        while(l<=h){
            mid = l + (h-l)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid]>=nums[l]){  // left part is sorted
                if(nums[l]<=target && nums[mid]>target){
                    h = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
            else{ //right part is sorted
                
                if(nums[mid]<target && nums[h]>=target){
                    l = mid+1;
                }
                else{
                    h = mid-1;
                }
                
            }
            
        }
        return -1;
        
    }
}