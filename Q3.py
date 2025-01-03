######### Search in an array of unknown length ###########

# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# keep doubling the search range until we reach greater than or equal to the target
# then within the search range perform binary search and return the index


# sample reader for testing purposes
def reader(index):
    arr = [i for i in range(1,1000)]
    return arr[index]


def element_exists(target):
	l = 0
	r = 1
	while reader(r)  < target:
		l = r
		r = r*2
  
	while l <= r:
		mid = (l+r)//2
		if reader(mid)==target:
			return mid
		elif reader(mid) > target:
			r = mid - 1
		else:
			l  = mid  + 1

print(element_exists(50))
