/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
//TC: O(logn)
//SC: O(1) - as fixed memory is required for l, h, mid and it doesnot change with input size. No additional arrays, stack is required.

class Solution {
    public int search(ArrayReader reader, int target) {
        int l = 0;
        int h = 1;
        while(reader.get(h) < target){
            l = h;
            h = 2*h;
        }
        while(l <= h){
            int mid = l + (h-l)/2;
            if(reader.get(mid) == target){
                return mid;
            }
            else if(target < reader.get(mid)){
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return -1;
    }
}