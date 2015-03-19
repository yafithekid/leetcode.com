class Solution:
    # @param n, an integer
    # @return an integer
    def climbStairs(self,n):
        a = 1
        b = 1
        c = 1
        for i in range(2,n+1):
        	c = a + b
        	a = b
        	b = c
       	return c

obj = Solution()
print(obj.climbStairs(2))
print(obj.climbStairs(3))
print(obj.climbStairs(4))
