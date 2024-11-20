

// Search in Infinite sorted array:

// https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

// Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.
public class Main {
    public static void main(String[] args) {
        public int search(reader, target);
    }
    
      public int search(ArrayReader reader, int target){
        int low = 0;
        int high = 1;//we can also make high as upper range 9999 but to achieve balance we are                            //finding range first
        
        while(reader.get(high) < target){//while target is not in range tc- O(logm) as we inscrease //the size of high logm deceases and logk increases
            low = high; //moving low to high
            high = 2*high;// moving high to twice its size
        }//giving the range of target ntw low and high 
        
        //doing regular binary search on low and high range
        
        while(low <=high){//tc- logk
            int mid = low + (high-low)/2;
            if(reader.get(mid) == target) return mid;
            else if(reader.get(mid) > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        
        return -1;//if target is not there
    }
}



