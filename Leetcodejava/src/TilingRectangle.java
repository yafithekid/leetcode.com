import java.lang.reflect.Array;
import java.util.Arrays;

public class TilingRectangle {
    public TilingRectangle(){
//        new Solution().tilingRectangle(2,3);
        int i = new Solution().tilingRectangle(11, 13);
        System.out.println(i);
    }

    public static void main(String[] args){
        new TilingRectangle();
    }


    class Solution {
        public int [][][][] dp = new int[18][18][18][18];
        int f(int ra,int ca,int rb,int cb){
            if (ra > rb || ca > cb) return 0;
            if (dp[ra][ca][rb][cb] != -1) return dp[ra][ca][rb][cb];
            int ret = 1_000_000_000;
            for(int i = 1; ra + i - 1 <= rb && ca + i - 1 <= cb; i++){
                ret = Math.min(ret,f(ra,ca+i,ra + i - 1,cb) + f(ra +i,ca,rb,cb) + 1);
                ret = Math.min(ret,f(ra+i,ca,rb,ca+i-1) + f(ra,ca+i,rb,cb) + 1);
            }
            dp[ra][ca][rb][cb] = ret;
            System.out.printf("f(%d,%d,%d,%d) = %d\n",ra,ca,rb,cb,ret);
            return ret;
        }

        public int tilingRectangle(int n, int m) {
            for(int i = 0; i < 18; i++){
                for(int j = 0; j < 18; j++){
                    for(int k = 0; k < 18; k++){
                        for(int l = 0; l <18; l++){
                            dp[i][j][k][l] = -1;
                        }
                    }
                }
            }
            return f(0,0,n-1,m-1);

        }
    }
}
