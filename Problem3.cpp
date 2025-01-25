// Search in a Sorted Array of Unknown Size

//Time Complexity: O(log(m) + log(n))[Since I am increasing the size of the array by 2 times]
//Space Complexity: O(1)
// Code ran successfully on leetcode
// Approach:

//Initially starting low and high at 0 and 1 whilst increasing right by 2x. Once target is within range performing binary search.

class Solution {
public:
    int search(const ArrayReader& reader, int target) {
        int left = 0;
        int right = 1;

        while (reader.get(right) < target && reader.get(right) != INT_MAX) {
            left = right;         
            right = right * 2;     
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = reader.get(mid);

            if (val == target) {
                return mid;        
            } else if (val < target) {
                left = mid + 1;    
            } else {
                right = mid - 1;   
            }
        }

        return -1; 
    }
};
