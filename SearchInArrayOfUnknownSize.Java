
## Problem:3 
Search in Infinite sorted array: 
https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

// Time Complexity :O(log(n))
// Space Complexity :Constant Space
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


 class Solution 
 {
    public int search(ArrayReader reader, int target) 
    {
        int low=0;
        int high=1;
        while(target>reader.get(high))
        {
            low=high;
            high=high*2;
        }
        return binarySearch(reader,low,high,target);
    }

    private int binarySearch(ArrayReader reader, int low, int high, int target)
    {
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(reader.get(mid)==target)
            {
                return mid;
            }
            else if(target>reader.get(mid))
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return -1;
    }
}