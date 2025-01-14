class ArrayReader:
    """Simulates the interface provided in the problem."""

    def __init__(self, arr):
        self.arr = arr

    def get(self, index: int) -> int:
        if index < 0 or index >= len(self.arr):
            return float('inf')  # Simulates out of bounds
        return self.arr[index]


class Solution:
    def search(self, reader: ArrayReader, target: int) -> int:
        """
        Searches for the target in an infinite sorted array.
        Args:
        reader (ArrayReader): Interface to access elements of the array.
        target (int): The value to search for.

        Returns:
        int: Index of the target or -1 if not found.
        """
        # Step 1: Determine search bounds
        left, right = 0, 1

        # Expand the search bounds exponentially
        while reader.get(right) < target:
            left = right
            right *= 2

        # Step 2: Perform binary search within the bounds
        while left <= right:
            mid = left + (right - left) // 2
            mid_value = reader.get(mid)

            if mid_value == target:
                return mid
            elif mid_value < target:
                left = mid + 1
            else:
                right = mid - 1

        return -1


# Test the Solution
if __name__ == "__main__":
    # Example input
    arr = [-1, 0, 3, 5, 9, 12, 15, 20, 25]
    reader = ArrayReader(arr)
    solution = Solution()

    # Test case 1: Target exists
    target = 9
    print(solution.search(reader, target))  # Output: 4

    # Test case 2: Target does not exist
    target = 8
    print(solution.search(reader, target))  # Output: -1

    # Test case 3: Target is out of bounds
    target = 100
    print(solution.search(reader, target))  # Output: -1
