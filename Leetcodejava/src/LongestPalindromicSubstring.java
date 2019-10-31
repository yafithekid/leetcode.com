public class LongestPalindromicSubstring {
    public static void main(String[] args){
        new LongestPalindromicSubstring();
    }

    public LongestPalindromicSubstring(){
        String babad = new Solution().longestPalindrome("babad");
        System.out.println(babad);
    }

    class Solution {
        public String longestPalindrome(String s) {
            int max = 0,ml=0,mr=0;
            for(int m = 0; m < s.length(); m++){
                //odd
                for(int l = m, r = m+1; l >= 0 && r < s.length(); l--,r++){
                    if (s.charAt(l) != s.charAt(r)) break;
                    if (r - l + 1 > max){
                        ml = l; mr = r; max = r - l + 1;
                    }
                }
                //even
                for(int l = m, r = m; l >= 0 && r < s.length(); l--,r++){
                    if (s.charAt(l) != s.charAt(r)) break;
                    if (r - l + 1 > max){
                        ml = l; mr = r; max = r - l + 1;
                    }
                }
            }
            return s.substring(ml,mr+1);
        }
    }

}
