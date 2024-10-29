//for a 2d matrix we will fetch our row and coloumn index by using / and % with coloumn size
//and we will apply bs as usual here if the element is greater than target move left else move right side of the array
class Solution {
public:
// r = mid/n c =mid/n
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int n = matrix.size();
        int m = matrix[0].size();
        int low = 0;
        int high = m*n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int r = mid/m;
            int c= mid%m;
            if(matrix[r][c]==target){ 
                return true;
                }
            else if(matrix[r][c]>target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return false;
    }
};