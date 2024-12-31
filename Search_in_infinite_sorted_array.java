// ## Problem3
// Search in Infinite sorted array: 

// https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

// Given a sorted array of unknown length and a number to search for, return the index of the number in the array. 
// Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. 
// If it isn’t present, return -1.

// It is a leetcode premium question

// Solution:
// Description: 
// In this we will first find the index as we dont know the size of an array. Also, 
// The approach we will follow is: At the start we will keep low at 0 and high at 1 and check if the arr[high] > target. 
// we will keep increasing low to high and high by 2 in each step till we meet a condition that the target may low between low and high 
// Now here why are we multiplying by 2 and not by 3, 4 or taking a square etc. Because, in binary search we divide the space in 2 and also 
// we dont want to increase the search space as once we get the indexes we will then have to apply Binary Search
// Time Complexity :O (log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : I didn't tried it as I was not having an premium

//This was an interface provided
interface ArrayReader{
    public int get(int index);
}

class Solution implements ArrayReader{
    private int[] arr;   //Declared an array
    public Solution(int[] arr){
        this.arr=arr;
    }
    public int get(int index){          //This overriden method returns the element of an array if the element at that index exists else return an infinite value
        
        if(index >=arr[0] && index <= arr.length-1){
            return arr[index];
        }
        else{
            return Integer.MAX_VALUE;
        }
    }

    public int search(Solution reader, int target){  //This method finds the low and high index between which the target mey exist and calls the binarysearch method 

        int low=0;
        int high=1;

        while(reader.get(high)<target){
            low=high;
            high=high*2;
        }
        return binarySearch(low,high,target);

    }

    public int binarySearch(int low, int high, int target){ //This is the normal binary search method 
        while(low<=high){
            int mid=low+(high-low)/2;
            if(target == get(mid)){
                return mid;
            }
            else if(target > get(mid)){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args){  //Main method in which I am creating an object and calling a search method
        int arr[]={1,2,3,4,5,6,7,8,9,10};
        Solution solution = new Solution(arr);
        int targetIndex = solution.search(solution,81);
        if(targetIndex ==-1){
            System.out.println("Target Element Not Found");
        }
        else{
            System.out.println("Target Element Found at index "+ targetIndex);
        }

    }
}