import java.util.*;

public class TwoSum {
    public static void main(String[] args){
        new TwoSum();
    }

    public TwoSum(){
//        int[] ints = new Solution().twoSum(new int[]{2, 7, 11, 15,15}, 30);
        int[] ints = new Solution().twoSum(new int[]{0,4,3,0}, 0);
        System.out.println(Arrays.toString(ints));
    }

    class Record {
        public int x;
        List<Integer> position;


        public Record(int x,List<Integer> position) {
            this.x = x;
            this.position = position;
        }
    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Record> x = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (!x.containsKey(nums[i])) {
                    List<Integer> integers = new ArrayList<>();
                    x.put(nums[i],new Record(nums[i],integers));
                }
                Record record = x.get(nums[i]);
                record.position.add(i);
            }
            for(int i = 0; i < nums.length; i++){
                int k = target - nums[i];
                if (x.containsKey(k)){
                    if (k == nums[i] && x.get(k).position.size() >= 2){
                        return new int[]{x.get(k).position.get(0),x.get(k).position.get(1)};
                    } else if (k != nums[i]){
                        return new int[]{x.get(nums[i]).position.get(0),x.get(k).position.get(0)};
                    } else {
                        continue;
                    }
                }
            }
            throw new IllegalStateException();
        }
    }
}
