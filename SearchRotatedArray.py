#Time Complexity = O(log n)

class Solution:

    def search(self, nums: list[int], target: int) -> int:
        self.low = 0
        self.high = len(nums) - 1

        while self.low <= self.high:
            self.mid = int((self.low + self.high) / 2)
            if target == nums[self.mid]:
                return self.mid
            elif nums[self.low] <= nums[self.mid]:      # left sorted
                if target >= nums[self.low] and target < nums[self.mid]:
                    self.high = self.mid - 1
                else:
                    self.low = self.mid + 1
            else:                                    # right sorted
                if target > nums[self.mid] and target <= nums[self.high]:
                    self.low = self.mid + 1
                else:
                    self.high = self.mid - 1

        return -1
