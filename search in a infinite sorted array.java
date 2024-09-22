// Time Complexity : O(log(k))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :no(needs premium will invest in premium soon)
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
implemented the code by sliding window method
 */
class solution{
	public int search(ArrayReader reader, int target){
		int low = 0;
		int high = 1;
		while(reader.get(high) < target)
		{
			low = high;
			high = 2 * high;
		}
		
		while(low <= high)
		{
			int mid = low + (high - low)/2;
			if(reader.get(mid) == target)
			{
				retur mid;
			}
			else
			{
				if(reader.get(mid) > target)
				{
					high = mid -1;
				}
				else
				{
					low = mid + 1;
				}
			}
		}
		if(reader.get(high) == target) return high;
		return -1;
	}
}