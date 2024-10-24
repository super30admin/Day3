// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No problem
// Approach - since we dont know the length of  the array, everytime the right element is less than the
//target we multiply the right *2 and then left = right, then we carry out regular binary search for the given
//left and right


/**
 * SearchInUnknownSize : SearchInUnknownSize
 *
 * @author : Kavya Mandaliya (kmandali@cisco.com)
 * @version : 1.0 (Oct 24, 2024)
 * @since : 1.0 (Oct 24, 2024)
 */
import java.util.*;

public class SearchInUnknownSize {
	public int search(ArrayReader reader, int target) {
		int left = 0, right = 1;
		if(reader.get(left) == target) return left;
		while(reader.get(right) < target){
			left = right;
			right = right * 2;
		}
		int mid, num;
		while(left <= right){
			mid = left + ((right - left) >> 1);
			num = reader.get(mid);
			if(num == target) return mid;
			else if(num < target) left = mid+1;
			else right = mid-1;
		}
		return -1;
	}
	
}
