// Time Complexity :o(logn)
// Space Complexity :o(1) 
// Did this code successfully run on Leetcode : it runs good in leat code
// Any problem you faced while coding this : no

class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        if(n==0|| nums==null){
            return -1;
        }
        {
            int low= 0; int high= n-1;
            while(low<high){
                int mid= low+(high-low)/2;
                if(nums[mid] == target){
                     return mid;
            } else if(nums[low]<=nums[mid]){
                    //left sorted 
                
                if(nums[low]<=target&&nums[mid]>target){
                high=mid-1;
            } else {
                        low=mid+1;
                    }
                    }else {
                    if(nums[mid]<target&&target<=nums[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }

        }
        if(nums[low]==target)return low;
        return -1;
    }
    }
    }