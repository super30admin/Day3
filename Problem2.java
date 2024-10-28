// Time Complexity :O(LogN)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No



class Solution {
    public int search(int[] nums, int target) {
        int pivot = getPivot(nums,0,nums.length-1);
        int left = bs(nums,0,pivot,target);
        if(left != -1){
            return left;
        }else{
            return bs(nums,pivot+1,nums.length-1,target);
        }

    }

    int getPivot (int[] nums,int low ,int high){


        while(low<=high){
            int mid = low + (high-low)/2;
             //if mid > mid+1 then mid is the pivot
            if(mid<high && nums[mid] > nums[mid+1]){
                return mid;
            }
            //if mid < mid-1 then mid-1 is the answer
            if(mid>low && nums[mid] < nums[mid-1]){
                return mid -1;
            }

            if(nums[mid] <= nums[low]){
                high= mid-1;
            }else{
                low = mid+1;
            }









        }
        return -1;
    }


    int bs (int[] nums,int low ,int high,int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(target > nums[mid]){
                low = mid+1;
            }else if(target < nums[mid]){
                high = mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}





