class Solution:
    # @param {string} word1
    # @param {string} word2
    # @return {integer}
    def max(self,one,two):
    	return one if one > two else two

    def cost(self,i1,i2,dp):
    	if (i1 < 0 or i2 < 0):
    		return self.max(i1 + 1,i2 + 1)
    	else:
    		return dp[i1][i2]

    def min(self,one,two,three):
    	if (one < two):
    		return one if (one < three) else three
    	else:
    		return two if (two < three) else three

    def minDistance(self, word1, word2):
    	if (len(word1) == 0):
    		return len(word2)
    	elif (len(word2) == 0):
    		return len(word1)
        dp = [[-1 for x in range(len(word2))] for x in range(len(word1))]
        for i in range(len(word1)):
        	for j in range(len(word2)):
        		if word1[i] == word2[j]:
        			dp[i][j] = self.cost(i-1,j-1,dp)
        		else:
        			dp[i][j] = 1 + self.min(self.cost(i-1,j,dp),self.cost(i,j-1,dp),self.cost(i-1,j-1,dp))
        		# print(i,j,dp[i][j])
        return dp[len(word1)-1][len(word2)-1]


print (Solution()).minDistance("ab","bc")

