// we are given a rotated sorted array
//[1,2,3,4,5]
//[2,3,4,5,6,7,1]

// now we know we can apply the searching algorithm like binary search to sorted arrays
// so first brute force would be to traverse through all the elements but it will take O(n) time
// one property i can notice is even rotated one half the array is always in sorting order so if 
// we can check target lys in that half we can search it through binary search, or we can eliminate
// that half , 

// so here let say target is 3 , if we put start = 0 , end = 4 , mid = 2
//so 5 is mid , it is not the target,
// let us check if the array is sorted on left or right
// so if array[start] < mid it is left sorted
// we can check if target is within left range 
// if yes we can update the indexes 
// else we will update the start and perform the same on right unsorted part and we will check which 
// part is sorted in this case left again then we can update the index again 
// now when we do this it 
// else right sorted
//  and if the target is in range of mid to end
// update the start to mid +1
// else 
// discard that part

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int start = 0;
        int end = nums.size()-1;

        while(start <= end)
        {
            int mid = start + (end- start)/2;
            //check if the mid is the target
            if(nums[mid]== target)
                return mid;
            
            // find the sorted part
            if(nums[start] <= nums[mid])
            {
                // check if the target is in sorted part
                if(target >= nums[start] && target <= nums[mid])
                    end = mid-1;
                else
                    start = mid +1;
            }
            else
            {
                //if not left right is sorted
                if(target >= nums[mid] && target <= nums[end])
                    start = mid+1;
                else
                    end = mid -1;
            }
        }
        
        return -1;
    }
};