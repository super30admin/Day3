// Time Complexity : O(log(m) + log(n))

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : Yes

// Any problem you faced while coding this : There were a lot of syntax errors since, 
// I am using c++ after a very long time
// Since I am building on top of the class lecture the logic worked out fine


// Your code here along with comments explaining your approach in three sentences only
// Using binary search base logic, Since we do not know the length of the array
// We double at every check to see if the target is in the range and once 
// we find the range then we apply binary search on the range 

#include <cmath>
#include <iostream>

class ArrayReader {
   public:
        int max_idx = 2000;

        int get(int index) const {
            if (index < max_idx){
                return index;
            }
            return pow(2, 31) - 1;
        }
 };
     
 
      

class Solution {
    public:
        int search(const ArrayReader& reader, int target) {
            int l = 0;
            int h = 1;
            if (reader.get(l) == target) return l;
            if (reader.get(h) == target) return h;
            while (reader.get(h) < target){
                l = h;
                h = h * 2;
            }
            while (l <= h){
                int mid = l + (h - l)/2;
                if (reader.get(mid) == target) return mid;
                else{
                    if (reader.get(mid) < target) l = mid + 1;
                    else h = mid - 1;
                }
            }
            return -1;
        }
};

int main(){
    Solution sol = Solution();
    int rows = 7;
    ArrayReader arry_reader = ArrayReader();

    int result = sol.search(arry_reader, 6);
    std::cout <<"True  Result case output: "<< result << std::endl;

    result = sol.search(arry_reader, 4000);
    std::cout <<"False Result case output: "<< result << std::endl;
    return 0;
}
