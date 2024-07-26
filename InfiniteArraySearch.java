// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class InfiniteArraySearch {

    public int search(ArrayReader reader, int target) {
        int l =0; int h=1; 

        // find range of the searchable subarray
        while (reader.get(h) < target) {
            l= h;
            h = 2*h;
        }

        //binary search whitin the sub array
        while (l <= h) {
            int mid = l + (h-l)/ 2;
            if (reader.get(mid)== x)  return mid;
            else if (reader.get(mid) < x)  l = mid + 1;
            else h = mid - 1;     
        }

        return -1;
    } 
}