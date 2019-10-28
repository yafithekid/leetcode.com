import java.util.ArrayList;
import java.util.List;

public class FindFunction {
    /*
     * // This is the custom function interface.
     * // You should not implement it, or speculate about its implementation
     * class CustomFunction {
     *     // Returns f(x, y) for any given positive integers x and y.
     *     // Note that f(x, y) is increasing with respect to both x and y.
     *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
     *     public int f(int x, int y);
     * };
     */
    interface CustomFunction {
             public int f(int x, int y);
    };

    class Solution {
        public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
            List<List<Integer>> ret = new ArrayList<>();
            for(int i = 1; i <= 1000; i++){
                for(int j = 1; j <= 1000; j++){
                    if (customfunction.f(i,j) == z){
                        List<Integer> sol = new ArrayList<>();
                        sol.add(i); sol.add(j);
                        ret.add(sol);
                    }
                }
            }
            return ret;
        }
    }
}
