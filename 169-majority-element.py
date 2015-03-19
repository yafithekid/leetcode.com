import math

class Solution:
    # @param num, a list of integers
    # @return an integer
    def majorityElement(self, num):
        count = {}
        for x in num:
        	count[x] = count.get(x,0) + 1
        minsz = math.ceil(len(num)/2.0)
        for i in count:
        	print(i,count.get(i))
        key = None
        for i in count:
        	if ((key == None) or (count.get(key) < count.get(i))):
        		key = i
       	return key

#obj = Solution
#Solution.majorityElement(obj,[1,1,4,3,5,1])
