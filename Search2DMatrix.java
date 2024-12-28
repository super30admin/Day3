// Approach: Identify the correct row to search in before applying binary search on that row. To find this row index, use binary search
// to determine the index of the closest smaller element to the target in the first column of the matrix. Once the row index is determined,
// apply binary search to check whether the element is present in that row.
// Time Complexity : O(logr + logn) where r - #rows
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Search2DMatrix {

    int findClosestSmallerElement(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        int idx = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == k) {
                idx = mid;
                break;
            } else if (arr[mid] < k) {
                idx = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return idx;
    }

    int[] getFistCol(int[][] matrix) {
        int[] arr = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            arr[i] = matrix[i][0];
        }
        return arr;
    }

    public static void main(String[] args) {
        Search2DMatrix s2dm = new Search2DMatrix();
        int[][] matrix = {
                { 1, 2, 3, 4, 5 },
                { 6, 7, 8, 9, 10 },
                { 11, 12, 13, 14, 15 },
                { 16, 17, 18, 19, 20 }
        };
        int k = 10;
        int[] arr = s2dm.getFistCol(matrix);
        int row = s2dm.findClosestSmallerElement(arr, k);
        if (row == -1) {
            System.out.println("Element not found..");
            return;
        }
        int col = s2dm.findClosestSmallerElement(matrix[row], k);
        if (col == -1 || matrix[row][col] != k) {
            System.out.println("Element not found..");
            return;
        }
        System.out.println("Element found at matrix position: [" + row + "][" + col + "]");
    }
}