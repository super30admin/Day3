public class Solution1
{
        public int search(int[] nums, int target)
        {
            int n=nums.length;
            int start=0,mid;
            int end=n-1;

        /*if(n==1)
        {
            if(nums[0]==target)
                return 0;
            else
            return -1;
        }
        else if(n==2)
        {
            if(nums[0]==target)
            return 0;
            else if(nums[1]== target)
            return 1;
            else
            return -1;
        }*/

            while(start<=end)
            {
                mid=(start+end)/2;
                if(nums[mid]== target)
                    return mid;

                if(nums[start]<=nums[mid])
                {
                    if(nums[start]<= target && nums[mid]>= target)
                    {
                        end= mid-1;
                    }
                    else
                    {
                        start=mid+1;
                    }
                }
                else
                {
                    if(nums[mid]<= target && nums[end]>= target)
                    {
                        start=mid+1;
                    }
                    else
                    {
                        end=mid-1;
                    }

                }

            }
            return -1;
        }
        public static void main(String[] args) {
            Solution1 solution = new Solution1();
            int[] nums={4,5,6,7,0,1,2};
            System.out.println(solution.search(nums,5));
        }
   }

