/**
 TC: O(log(n)) where n is the number of elements in the input array
 SC: O(1)
 Solved in LC: Yes
 */
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
  var left=0,right=nums.length-1;
    while(left<=right){
        var mid=Math.floor((left+right)/2);
        if(nums[mid]==target){return mid;}
        if(nums[left]<=nums[mid]){
            nums[left]<=target && target<=nums[mid] ? right = mid-1:left=mid+1;
        }else if (nums[mid]<=nums[right]){
            nums[mid]<=target && target<=nums[right] ? left = mid+1 : right = mid-1;
        }
    }
    return -1;  
};
console.log(search([4,5,6,7,0,1,2],0));