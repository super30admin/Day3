// Time Complexity : O(log(row))

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : Yes

// Any problem you faced while coding this : There were a lot of syntax errors since, 
// I am using c++ after a very long time
// Since I am building on top of the class lecture the logic worked out fine


 // Your code here along with comments explaining your approach in three sentences only
 // I am using finding the sorted array logic where I try to find the sorted array and if the target is 
 // within the range then I apply binary sort

#include <iostream>
#include <vector>

class Solution {
public:
    int search(std::vector<int>& nums, int target) {
        int l = 0;
        int h = nums.size() - 1;
        while(l <= h){
            int mid = l + (h - l)/2;
            if (nums[mid] == target) return mid;
            else{
                if (nums[l] <= nums[mid]){
                    if (nums[l] <= target && target < nums[mid]){
                        h = mid - 1;
                    }
                    else l = mid + 1;
                }
                else{
                    if(nums[mid] < target && target <= nums[h]){
                        l = mid + 1;
                    }
                    else{
                        h = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
};

int main(){
    Solution sol = Solution();
    int rows = 7;
    std::vector<int> matrix = {4, 5, 6, 0, 1, 2, 3};

    int result = sol.search(matrix, 6);
    std::cout <<"True  Result case output: "<< result << std::endl;

    result = sol.search(matrix, 400);
    std::cout <<"False Result case output: "<< result << std::endl;
    return 0;
}
