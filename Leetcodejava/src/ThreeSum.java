import java.util.*;

public class ThreeSum {
    public static void main(String[] args){
        new ThreeSum();
    }

    public ThreeSum(){
        List<List<Integer>> lists = new Solution().threeSum(new int[]{-1, 0, 0, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);

            Map<Integer,Integer> exist = new TreeMap<>();
            for(int num: nums){
                if (!exist.containsKey(num)) {
                    exist.put(num,0);
                }
                exist.put(num,exist.get(num)+1);
            }
            List<List<Integer>> result = new ArrayList<>();

            List<Integer> choices = new ArrayList<>(exist.keySet());

            for(int k = 0; k < choices.size(); k++){
                int a = choices.get(k);
                for(int i = k; i < choices.size(); i++){
                    int b = choices.get(i), c = 0 - a - choices.get(i);
                    if (k == i && exist.get(b) < 2) continue;

                    if (c < a || c < b) continue;
                    if (!exist.containsKey(c)) continue;
                    if (c == b){
                        if (b == a){
                            if (exist.get(c) < 3) continue;
                        }
                        if (exist.get(c) < 2) continue;
                    }
                    result.add(Arrays.asList(a,b,c));
                }
            }
            return result;
        }
    }
}
