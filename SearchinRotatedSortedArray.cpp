//The optimal approach here is to use binary search and 
//check if our target is in the sorted range if not that it will lie in the unsorted one or it might not be there.
class Solution {
public:
  //Identify the sorted half
    int search(vector<int>& nums, int target) {
        int s =0;
        int e = nums.size()-1;
        while(s<=e){
            int mid = e+(s-e)/2;
            if(nums[mid]==target) return mid;
            if(nums[e]>=nums[mid]){
                 if(target<=nums[e] && target>=nums[mid]) s = mid+1;
                 else{
                    e = mid-1;
                 }
            }
            else{ // nums[e]<=nums[mid] //left sorted
                 if(target>=nums[s] && target<=nums[mid]){
                    e = mid-1;
                 }
                 else{
                    s =mid+1;
                 }
            }
            }
        
        return -1;
    }
};