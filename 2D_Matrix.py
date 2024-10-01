class Solution:
    def searchMatrix(self, matrix, target: int) -> bool:
        outer_low, inner_low = 0,0
        inner_high = len(matrix[0])-1
        outer_high = len(matrix)-1
        
        if matrix[outer_low][inner_low] > target or target > matrix[outer_high][inner_high]:
            print("Not In The Matrix")
            return False
        
        while outer_low <= outer_high:
            mid = (outer_high + outer_low) // 2
            
            if matrix[mid][inner_low] <= target <= matrix[mid][inner_high]:
                break
            
            elif target > matrix[mid][inner_high]:
                outer_low = mid + 1
                mid = (outer_high + outer_low) // 2    
            
            else:
                outer_high = mid - 1
                mid = (outer_high + outer_low) // 2            
        
        outer_mid = mid
        low = inner_low
        high = inner_high
        arr = matrix[mid]
        
        while low <= high:
            mid = (low + high) // 2
            
            if target == arr[mid]:
                print("Found at row ", outer_mid," column ", mid)
                return True
            
            elif target > arr[mid]:
                low = mid + 1
                
            else:
                high = mid - 1
        
        #print(outer_mid)
        return False