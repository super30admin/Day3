#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
bool searchMatrix(vector<vector<int>>& matrix, int target) {
    int m = matrix.size(), n = matrix[0].size();
    int low = 0, high = m-1;
    while(high-low>1){
        int mid = (low+high)/2;
        if(matrix[mid][n-1]==target) return true;
        else if(matrix[mid][n-1]<target){
            low = mid+1;
        }
        else{
            high = mid;
        }
    }
    if(matrix[low][n-1]==target) return true;
    else if(matrix[low][n-1]<target) low=high;
    return binary_search(matrix[low].begin(),matrix[low].end(),target);
}
int main(){
    vector<vector<int>> matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
    int target = 3;
    cout<<searchMatrix(matrix,target);
    return 0;
}