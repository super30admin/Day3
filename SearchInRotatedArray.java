// Time Complexity : O(log n )
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
//Approach - we compare the mid with low,so if low < mid then it means that the left half is sorted and if the target is in the left half
//we do BS in the left half, or else in the right half


/**
 * SearchInRotatedArray : SearchInRotatedArray
 *
 * @author : Kavya Mandaliya (kmandali@cisco.com)
 * @version : 1.0 (Oct 24, 2024)
 * @since : 1.0 (Oct 24, 2024)
 */
public class SearchInRotatedArray {
	
	
	public int search(int[] nums, int target) {
		int left = 0, right = nums.length-1;
		while(left <= right){
			int mid = left + (right - left)/2;
			
			if(nums[mid] == target){
				return mid;
			}
			else if(nums[mid] >= nums[left]){
				//left half is sorted
				if(target >= nums[left] && target < nums[mid])
					right = mid -1;
				else
					left = mid+1;
			}
			else{
				//right half is sorted
				if(target <= nums[right] && target > nums[mid]){
					left = mid +1;
				}else{
					right = mid-1;
				}
			}
		}
		return -1;
	}

}
