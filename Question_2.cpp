#include <bits/stdc++.h>
#include <iostream>
#include <vector>
using namespace std;


int check(vector<int>&nums,int beg,int end, int target){
    int n = nums.size();
    int ind = lower_bound(nums.begin()+beg,nums.begin()+end+1,target)-nums.begin();
    if(ind==n||nums[ind]!=target) return -1;
    return ind;
}
int search(vector<int>& nums, int target) {
    int n = nums.size();
    bool is_rotated = nums[0]>nums[n-1];
    if(!is_rotated){
        return check(nums,0,n-1,target);
    }
    int low = 0, high = n-1;
    while(high>low){
        int mid = (low+high)/2;
        if((mid+1<n&&nums[mid+1]<nums[mid])||(mid-1>=0&&nums[mid-1]>nums[mid])){
            if(mid+1<n&&nums[mid+1]<nums[mid]){
                low = mid+1;
                high = mid+1;
            }
            else{
                low = mid;
                high = mid;
            }
        }
        else{
            if(nums[mid]>nums[0]) low = mid+1;
            else high = mid-1;
        }
    }
    int p1 = check(nums,0,low-1,target);
    int p2 = check(nums,low,n-1,target);
    return max(p1,p2);
}
int main(){
    vector<int> nums = {4,5,6,7,0,1,2};
    int target = 0;
    cout<<search(nums,target);
    return 0;
}