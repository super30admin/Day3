// Time Complexity :search: O(log n) , in Binary search we're eliminating the half of the input
// Space Complexity :0(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

class SearchInRotatedSortedArray {

        public int search(int[] nums, int target) {
            int n = nums.length;
            int low = 0;
            int high = n-1;

            while(low<=high){
                int mid=low+(high-low)/2;

                if(nums[mid]==target){
                    return mid;
                } else if(nums[low]<=nums[mid]){ // left sorted array
                    if(nums[low]<=target && nums[mid]>target){
                        high = mid-1;
                    } else{
                        low = mid +1;
                    }
                } else {
                    if(nums[mid] <target && nums[high]>=target ){
                        low = mid+1;
                    } else {
                        high = mid-1;
                    }
                }
            }

            return - 1;

        }

    public static void main(String args[]) {
        SearchInRotatedSortedArray array = new SearchInRotatedSortedArray();
        int[] nums = new int[5];
        nums[0]= 5;
        nums[1]=6;
        nums[2]=1;
        nums[3]=2;
        nums[4]=4;


        System.out.println("index of the target is " +array.search(nums, 6));

    }
}
