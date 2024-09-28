// time complexity - O(logn) and space complexity - O(1).



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