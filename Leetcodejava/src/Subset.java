import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void main(String[] args){
        new Subset();
    }

    public Subset(){
        System.out.println(new Solution().subsets(new int[]{1,2,3}));
    }

    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            boolean[] selected = new boolean[nums.length];

            rec(result,0,nums.length,nums,selected);
            return result;
        }

        void rec(List<List<Integer>> result,int c,int n,int[] nums, boolean[] selected){
            if (c == n){
                List<Integer> generated = new ArrayList<>();
                for(int i = 0; i < n; i++){
                    if (selected[i])
                        generated.add(nums[i]);
                }
                result.add(generated);
            } else {
                selected[c] = false;
                rec(result,c+1,n,nums,selected);
                selected[c] = true;
                rec(result,c+1,n,nums,selected);
            }
        }
    }
}
