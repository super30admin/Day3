class Solution
{
public:
    int search(vector<int> &nums, int target)
    {
        if (nums.size() == 0)
        {
            return -1;
        }

        int l = 0, h = nums.size() - 1;

        while (l <= h)
        {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target)
            {
                return mid;
            }

            if (nums[l] <= nums[mid])
            {
                if (target < nums[mid] && target >= nums[l])
                {
                    h = mid - 1;
                }
                else
                {
                    l = mid + 1;
                }
            }
            else
            {
                if (target > nums[mid] && target <= nums[h])
                {
                    l = mid + 1;
                }
                else
                {
                    h = mid - 1;
                }
            }
        }
        return -1;
    }
};