import java.util.Arrays;

public class JumpGame {
    public static void main(String[] args){
        new JumpGame();
    }

    public JumpGame(){
        boolean b = new Solution().canJump(new int[]{2, 3, 1, 1, 4});
//        boolean b = new Solution().canJump(new int[]{3,2,1,0,4});
        System.out.println(b);
    }

    class Solution {
        int[] visited;

        public boolean canJump(int[] nums) {
            int n = nums.length;
            visited = new int[n];
            Arrays.fill(visited,-1);
            return rec(0,nums) == 1;
        }

        int rec(int c,int[] nums){
            if (c == nums.length - 1) return 1;
            if (visited[c] != -1) return visited[c];

            visited[c] = 0;

            for(int i = Math.min(nums.length - 1 - c, nums[c]); i >= 1; i--){
                if (rec(c + i,nums) == 1){
                    visited[c] = 1;
                    break;
                }
            }
            return visited[c];

        }

    }
}
