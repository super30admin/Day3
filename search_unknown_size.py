'''
Time Complexity :
log(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : No
'''

def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        left,right=0,1
        while reader.get(right)<target and reader.get(right)!=2**31-1:
            left=right
            right*=2

        while left<=right:
            mid=(left+right)//2
            value = reader.get(mid)
            if value==target:
                return mid
            if value>target or value==2**31-1:
                right=mid-1
            if value<target:
                left=mid+1
            
        return -1