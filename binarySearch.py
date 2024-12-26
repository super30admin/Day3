def binarySearch(arr, l,r ,key):
	while l < r:
		mid = (l+r) // 2
	if arr[mid] == key:
		return mid
	elif arr[mid] < key:
		low = mid+1 
	else:
		r = mid -1
	return -1
	
def search_inf_array(arr,key):
	l = 0
	h = 1
	while arr[high]< key:
		l=h
		h=2*h
	return binarySearch(arr,l,r,key)
