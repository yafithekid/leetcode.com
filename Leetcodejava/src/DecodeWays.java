import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DecodeWays {
    public static void main(String args[]){
        System.out.println(new Solution1().numDecodings("1226"));
    }
}

class Solution1 {
    int dp[];
    int n;
    String s;
    Set<String> dict = new HashSet<>();

    public int f(int i){
        if (i == n){
            return 1;
        } else if (i > n){
            return 0;
        } else {
            System.out.println(i);
            if (dp[i] != -1) return dp[i];
            dp[i] = 0;

            String substring = s.substring(i,i+1);
            if (dict.contains(substring)) {
                dp[i] += f(i + 1);
            }
            if (i+1 < n){
                substring = s.substring(i,i+2);
                if (dict.contains(substring)){
                    dp[i] += f(i + 2);
                }
            }
            return dp[i];
        }
    }

    public int numDecodings(String s) {
        this.s = s;
        n = s.length();
        dp = new int[n];
        for(int i = 1; i <= 26; i++){
            dict.add(""+i);
        }
        for(int i = 0; i < n; i++){
            dp[i] = -1;
        }
        return f(0);
    }
}
