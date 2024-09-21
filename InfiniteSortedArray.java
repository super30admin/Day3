// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class solution{
	public int search(ArrayReader reader, int target){
		int low =0,high=0;
		if(reader.get(0)==Integer.MAX_VALUE) return -1;
		while(reader.get(high)<target){
			low=high+1;
			high=low*2;
		}
		
		while(low<=high){
			int mid = low +(high-low)/2;
			if(reader(mid)==target) return mid;
			if(reader(mid)>target){
				high = mid-1;
			}
			else{
				low = mid+1;
			}
		}
		return -1;
	}
}
