// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/* One part is always sorted.
Find sorted part and search for element in sorted part.
If not in sorted part, it will be in unsorted part.
*/
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int n = nums.size();
        if(n ==0){
            return -1;
        }
        int l=0;
        int h = n-1;
        int m=0;
        while(l<=h){
            m = l+(h-l)/2;
            if(nums[m]== target){
                return m;
            }
            //left side sorted and element lies in sorted side
            if(nums[l]<=nums[m]){
                if(nums[l]<=target && nums[m]> target){
                    h = m-1;
                }
                else{
                    l = m+1;
                }
            }
            else{
                if(nums[h]>=target && nums[m]< target){
                    l = m+1;
                }
                else{
                    h = m-1;
                }
            }
            

        }
        return -1;
    }
};