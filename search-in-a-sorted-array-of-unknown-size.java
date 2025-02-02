// Time Complexity :O(logm+logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :i did not run on it leetcode,
//  because i do not have premium subcription.
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach in three sentences only:
//Since the end of the array is unknown, I first determined the search range for binary search. 
// Instead of performing binary search from 0 to Integer.MAX_VALUE,
//  which would be inefficient, I optimized the process by expanding the search range exponentially. 
//  I started with low = 0 and high = 1, then doubled high (high = 2 * high) 
//  until reader.get(high) > target. Once the range was identified,
//  I applied a standard binary search within that range to efficiently locate the target.

public int searchMatrix(ArrayReader reader, int target) {
        System.out.println("Hello World!");
      
        int low=0; int high=1;
        while(reader.get(high) < target){//logm
            low=high;
            high=2*high;
        }
        while(low<=high){//logn
            int mid=low+(high-low)/2;
            if(reader.get(mid) == target){
                return mid;
            }else if(reader.get(mid) > target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }


