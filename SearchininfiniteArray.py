class Solution:
	def search(self, reader: 'ArrayReader', target: int) -> int:
		low=0
		high=1
		while reader.get(high)<target:
			low=high
			high=high*2		
		return self.binarysearch(reader, target, low, high)
	
	def binarysearch(self, reader: 'ArrayReader', target:int , low:int , high:int)->int:
		while low<=high:
			mid=low+(high-low)//2
			if reader.get(mid)==target:
				return mid
			elif reader.get(mid)<target:
				low=mid+1
			else:
				high=mid-1	
		return -1
