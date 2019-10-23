import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KClosestPoints {
    public static void main(String[] args){
        new KClosestPoints();
    }

    public KClosestPoints(){
        int[][] points = new int[][]{
                {3,3},{5,-1},{-2,4}
        };
        System.out.println(Arrays.deepToString(points));
//        boolean result = new WordBreak.Solution().wordBreak("applepenapple",Arrays.asList("apple", "pen"));
        int[][] result = new Solution().kClosest(points,2);
        System.out.println(Arrays.deepToString(result));
    }

    class Solution {
        public int[][] kClosest(int[][] points, int K) {
            Arrays.sort(points, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[0] * o1[0] + o1[1] * o1[1],o2[0] * o2[0] + o2[1] * o2[1]);
                }
            });
            int[][] ret = new int[K][];
            for(int i = 0; i < K; i++){
                ret[i] = points[i];
            }
            return ret;
        }
    }
}
