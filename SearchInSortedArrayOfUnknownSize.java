// Time Complexity : O(2LogN) ~ O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No



/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
/**
 * We use 2 binary searches here. First is used to find a index whose element is higher than target. We move low to high and high to high *2
 * to find range where target lies. Once high element is more is target or more than target we get out of loop.
 * Second BS is used to find the target in that range low to high. 
 * 
 *
 */
class Solution {
    public int search(ArrayReader reader, int target) {
        int low=0;
        int high=1;
        while(reader.get(high)<target){
            low=high;
            high=high*2;
        }
        while(low<high){
            int mid = low+ (high-low)/2;
            if(reader.get(mid)==target){
                return mid;
            }else if(reader.get(mid)>target){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        if(reader.get(high)==target){
            return high;
        }
        return -1;
    }
}