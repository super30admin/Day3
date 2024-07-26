// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class RotatedArraySearch {

    // finding the array which is sorted and using binary search on the subarray
    public int search(int[] a, int target) {
        int l=0; int r = a.length-1;

        while(l<=r){
            int mid = l + (r-l)/2;
            if(a[mid]==target) return mid;
            else{
                //check if left array is sorted or right
                if(a[l]<=a[mid]){
                    if(a[mid] > target && a[l] <= target) r = mid -1;
                    else l = mid +1;
                } else{
                    if(a[mid] < target && a[r]>=target) l = mid+1;
                    else r = mid-1; 
                }
            }
        }

        return -1;
    }
}