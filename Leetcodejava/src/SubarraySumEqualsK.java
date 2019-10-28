public class SubarraySumEqualsK {
    public static void main(String[] args){
        new SubarraySumEqualsK();
    }

    public SubarraySumEqualsK(){
        new Solution().subarraySum(new int[]{1,1,1},3);
    }

    class Solution {
        public int subarraySum(int[] nums, int k) {
            int[] sum = new int[nums.length];
            sum[0] = nums[0];
            for(int i = 1; i < nums.length; i++){
                sum[i] = sum[i-1] + nums[i];
            }
            int count = 0;
            for(int i = 0; i < nums.length; i++){
                for(int j = i; j < nums.length; j++){
                    int calc = sum[j];
                    if (i > 0){
                        calc -= sum[i-1];
                    }
                    if (calc == k) count++;
                }
            }
            return count;
        }
    }
}
