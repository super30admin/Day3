// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
#include <iostream>
#include <vector>

using namespace std;
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int i = 0;
        int j = nums.size()-1;
        while(i<=j) {
            int mid = (j-i)/2 +i;
            if (nums[mid] == target) return mid;
            else if (nums[i] <= nums[mid]) {
                if (nums[i] <= target && target < nums[mid]) j = mid -1;
                else i = mid+1;
            }
            else{
                if (target <= nums[j] && nums[mid] < target) i = mid+1;
                else j = mid-1;
            }
        }
        return -1;
    }
};