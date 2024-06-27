#The search method in the Solution class checks if a target integer exists in the provided list nums. It uses Python's in keyword to quickly determine if the target is present. If found, it returns the index of the target using index(target). If the target isn't in the list, it returns -1. This approach ensures that the method operates with O(n) time complexity, where n is the number of elements in nums, and O(1) space complexity since it uses a constant amount of extra space regardless of input size.

class Solution:
    def search(self, nums: list[int], target: int) -> int:
        z = nums
        if target in nums : 
            return  z.index(target)
        else : 
            return -1