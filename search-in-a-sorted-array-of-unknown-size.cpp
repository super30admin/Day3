// Approach: first checked if there was only 1 element and it was the target. started from 0 and 1 index as left and right, checked if val at right was < target. if yes, it meant element is further ahead. so made l as r and r as 2*r (to maintain logn time). after reaching the right window, did binary search. (if l was ever out of bounds, it meant element is not present)
// Time: O(logn)
// Space: O(1)

/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ArrayReader {
 *   public:
 *     int get(int index);
 * };
 */

class Solution {
    int binSearch(const ArrayReader& reader, int target, int l, int r) {
        
        while(l <= r) {    
            int mid = l + (r-l)/2;
            //cout<<l<<" "<<r<<" mid: "<<mid<<endl;
            if(reader.get(l) == INT_MAX) {
                return -1;
            }
            else if(reader.get(mid) == target) {
                return mid;
            }
            else if(reader.get(mid) < target) {
                l = mid+1;
            }
            else {
                r = mid-1;
            }
        }
        return -1;
    }
public:
    int search(const ArrayReader& reader, int target) {
        if(reader.get(0) == target) {
            return 0;
        }
        int l = 0, r = 1;
        while(reader.get(r) < target) {
            l = r+1;
            r = r*2;
            //cout<<l<<" "<<r<<endl;
        }
        if(reader.get(l) == INT_MAX) {
            return -1;
        }
        return binSearch(reader, target, l, r);
    }
};