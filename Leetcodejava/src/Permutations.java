import java.security.Permission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    public static void main(String[] args){
        new Permutations(new int[]{1,9,3});
    }

    public Permutations(int[] nums){
        System.out.println(new Solution().permute(nums));
    }

    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<Integer> collect = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());

            List<List<Integer>> result = new ArrayList<>();
            boolean[] visited = new boolean[nums.length];
            rec(result,new ArrayList<>(),collect,visited);
            return result;
        }

        void rec(List<List<Integer>> result,List<Integer> current,List<Integer> nums,boolean[] visited){
            if (current.size() == nums.size()){
                result.add(current);
            } else {
                for (int i = 0; i < nums.size(); i++) {
                    if (visited[i]) continue;
                    visited[i] = true;

                    List<Integer> added = new ArrayList<>(current);
                    added.add(nums.get(i));
                    rec(result,added,nums,visited);
                    visited[i] = false;
                }

            }
        }


    }
}
