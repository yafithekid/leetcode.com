import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args){
        new CoinChange();
    }

    public CoinChange(){
        int i = new Solution().coinChange(new int[]{1,3,4}, 6);
        System.out.println(i);
    }

    class Solution {
        int[] dp;

        public int coinChange(int[] coins, int amount) {
            dp = new int[amount + 100];
            Arrays.fill(dp,-1);

            for(int i = coins.length - 1; i >= 0; i--){
                solve(coins,amount);
            }
            int x = solve(coins,amount);

//            for(int i = 0; i <= amount; i++){
//                for(int j = 0; j < coins.length; j++){
//                    System.out.println("dp("+i+","+j+" = " +dp[i][j]);
//                }
//            }
            if (x == 1_000_000_000) x = -1;
            return x;
        }

        public int solve(final int[] coins, int amount){
            if (amount == 0) return 0;
            if (amount < 0) return 1_000_000_000;

            if (dp[amount] != -1) return dp[amount];

            dp[amount] = 1_000_000_000;
            for(int i = 0; i < coins.length; i++){
//                System.out.println(i + " " +(amount - coins[c] * i));
//                System.out.println(amount+" " + c+ " " +i+ " ");
                dp[amount] = Math.min(dp[amount], solve(coins,amount - coins[i])+1);
            }

            return dp[amount];
        }
    }
}
