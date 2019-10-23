import java.util.Arrays;

public class MaximumSubarray {
    public static void main(String[] args){
        new MaximumSubarray();
    }

    public MaximumSubarray(){
        int result = new MaximumSubarray.Solution().maxSubArray(new int[]{ -2,1,-3,4,-1,2,1,-5,4});
        System.out.println(result);
    }

    class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length, max = nums[0];
            for(int i = 1; i < n; i++){
                max = Math.max(max,nums[i]);
            }

            int currentSum = -2_000_000_000;

            for(int i = 0; i < n; i++){
                if (currentSum < 0){
                    currentSum = 0;
                }
                currentSum += nums[i];
                if (max < currentSum)
                    max = currentSum;
                System.out.println(i+" "+currentSum + " "+max);
            }
            return max;
        }
    }
}
