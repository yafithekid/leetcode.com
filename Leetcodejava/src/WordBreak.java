import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args){
        new WordBreak();
    }

    public WordBreak(){
//        boolean result = new WordBreak.Solution().wordBreak("applepenapple",Arrays.asList("apple", "pen"));
        boolean result = new WordBreak.Solution().wordBreak("leetcode",Arrays.asList("leet","code"));
        System.out.println(result);
    }

    class Solution {
        int[] dp;

        public boolean wordBreak(String s, List<String> wordDict) {
            dp = new int[s.length()];
            Arrays.fill(dp,-1);
            int result = rec(wordDict,s,0,s.length());
            System.out.println(Arrays.toString(dp));
            return result == 1;
        }

        int rec(List<String> wordDict,String s,int current, int n){
            if (current == n) return 1;

            if (dp[current] != -1) return dp[current];
            dp[current] = 0;
            for(int i = 0; i < wordDict.size(); i++){
                String comp = wordDict.get(i);
                try {
                    if (s.substring(current,current + comp.length()).equals(comp)){
                        dp[current] = dp[current] | rec(wordDict,s,current + comp.length(),n);
                    }
                } catch (IndexOutOfBoundsException e){
                    //do nothing
                }

            }
            return dp[current];
        }
    }
}
