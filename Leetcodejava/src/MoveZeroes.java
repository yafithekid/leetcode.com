import java.util.*;

public class MoveZeroes {
    public MoveZeroes(){
//        int[] arr = new int[]{0,1,0,3,12};
//        int[] arr = new int[]{1,3,12,1,1};
//        int[] arr = new int[]{0,0,0,0,0};
        int[] arr = new int[]{0,1,3,12,1,1};

        new Solution().moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args){
        new MoveZeroes();
    }

    class Solution {
        public void moveZeroes(int[] nums) {
            int i = 0, j = -1;
            for(int k = 0; k < nums.length; k++){
                if (nums[k] == 0){
                    j++;
                } else {
                    if (i <= j){
                        int x = nums[i];
                        nums[i] = nums[k];
                        nums[k] = x;
                    }
                    i++;
                    j++;
                }
            }
        }
    }


}
