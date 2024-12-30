//Time complexity: O(logn)
//space Complexity: O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

package Interview;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] =
				{4,5,6,7,0,1,2};
		System.out.println(search(nums,0));

	}
	
	public static  int search(int[] nums, int target) {
		if(nums.length == 0 || nums == null)
		{
			return -1;
		}
		int n = nums.length;
		int low =0;
		int high = n-1;
		while(low <= high) {
			int mid = low + (high-low)/2 ;
			if(nums[mid] == target) {
				return mid;
			}else {
				if(nums[low] <=  nums[mid]) {//check if the array is sorted
					if(target >= nums[low] && target < nums[mid]) { //check if the target is less than mid and greater than low, skiped the nums[mid] = target check because it's already done in line 26.
						high = mid-1;
					}else {
						low = mid+1;
					}
				}else {
					if(target > nums[mid] && target <= nums[high]) {//check if the target is less than high and greater than mid
						low = mid+1;
					}else {
						high = mid-1;
					}
					
				}
			}
		}	
		return -1;
	}
	

}
