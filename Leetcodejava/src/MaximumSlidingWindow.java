import java.util.*;

public class MaximumSlidingWindow {
    public static void main(String[] args){
        new MaximumSlidingWindow();
    }

    public MaximumSlidingWindow(){
//        int[] ints = new Solution().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
//        int[] ints = new Solution().maxSlidingWindow(new int[]{1,-1}, 1);
//        int[] ints = new Solution().maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3);
//        int[] ints = new Solution().maxSlidingWindow(new int[]{5,4,3,2,1,0,-1}, 3);
//        int[] ints = new Solution().maxSlidingWindow(new int[]{1,-9,8,-6,6,4,0,5}, 4);
        int[] ints = new Solution().maxSlidingWindow(new int[]{-95,92,-85,59,-59,-14,88,-39,2,92,94,79,78,-58,37,48,63,-91,91,74,-28,39,90,-9,-72,-88,-72,93,38,14,-83,-2,21,4,-75,-65,3,63,100,59,-48,43,35,-49,48,-36,-64,-13,-7,-29,87,34,56,-39,-5,-27,-28,10,-57,100,-43,-98,19,-59,78,-28,-91,67,41,-64,76,5,-58,-89,83,26,-7,-82,-32,-76,86,52,-6,84,20,51,-86,26,46,35,-23,30,-51,54,19,30,27,80,45,22},10);
        System.out.println(Arrays.toString(ints));
    }

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 0) return nums;

            List<Integer> list = new ArrayList<>();
            Deque<Integer> d = new ArrayDeque<>();

            for(int i = 0; i < k; i++){
                clean(d,i,k,nums);
                d.addLast(i);
//                while (d.size() >= 1 && ((nums[d.peekFirst()] <= nums[i]))) d.pollFirst();
//                System.out.println(i + " " +d);
            }
//            System.out.println(k+" "+d);
            list.add(d.peekFirst());
            for(int i = k; i < nums.length; i++){
                clean(d,i,k,nums);
                d.addLast(i);
//                clean(d,i,k,nums);
                list.add(d.peekFirst());
                System.out.print(i+" "); print(d,nums);
            }
            int[] ret = new int[list.size()];
            for(int i = 0; i < list.size(); i++){
                ret[i] = nums[list.get(i)];
            }
            return ret;
        }

        void print(Deque<Integer> d,int[] nums){
            System.out.print("[");
            for (Integer integer : d) {
                System.out.print(nums[integer]+ ",");
            }
            System.out.println("]");
        }

        void clean(Deque<Integer> d,int i,int k,int[] nums){
            while (d.size() > 0 && ((d.peekFirst() < i - k + 1))){
                d.pollFirst();
            }
            while (d.size() > 0 && ((d.peekLast() < i - k + 1))){
                d.pollLast();
            }
//            while (d.size() >= 2){
//                int first = d.pollFirst();
//                int second = d.pollFirst();
//                d.addFirst(second); d.addFirst(first);
//
//            }
            while (!d.isEmpty() && (nums[d.peekFirst()] <= nums[i])) d.pollFirst();
            while (!d.isEmpty() && (nums[d.peekLast()] < nums[i])) d.pollLast();
        }
    }
}
