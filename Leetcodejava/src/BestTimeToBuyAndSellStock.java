import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args){
        new BestTimeToBuyAndSellStock();
    }

    public BestTimeToBuyAndSellStock(){
//        boolean result = new WordBreak.Solution().wordBreak("applepenapple",Arrays.asList("apple", "pen"));
        int result = new BestTimeToBuyAndSellStock.Solution().maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(result);
    }

    class Solution {
        int[] rmax,rmin;

        public int maxProfit(int[] prices) {
            if (prices.length == 0) return 0;
            int n = prices.length;
            rmin = new int[n];
            rmax = new int[n];

            rmin[0] = prices[0];
            rmax[n-1] = prices[n-1];
            for(int i = 1; i < n; i++){
                rmin[i] = Math.min(rmin[i-1],prices[i]);
            }
            for(int j = n-2; j >=0; j--){
                rmax[j] = Math.max(rmax[j+1],prices[j]);
            }
            System.out.println(Arrays.toString(rmin));
            System.out.println(Arrays.toString(rmax));
            int result = 0;
            for(int i = 0; i + 1 < n; i++){
                System.out.println(i+" "+rmax[i+1]+" "+rmin[i]);
                result = Math.max(result,rmax[i+1] - rmin[i]);
            }
            return result;

        }
    }
}
