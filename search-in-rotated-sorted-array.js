/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function (nums, target) {
  let left = 0;
  let right = nums.length - 1;
  while (left <= right) {
    let mid = Math.round(left + (right - left) / 2);
    if (nums[mid] == target) {
      return mid;
    }
    // Check if left side is sorted
    if (nums[left] <= nums[mid]) {
      if (nums[left] <= target && nums[mid] >= target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    } else {
      // Right side is sorted
      if (nums[mid] <= target && nums[right] >= target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
  }
  return -1;
};

console.log(search([3, 1], 3));
