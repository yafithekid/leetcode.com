public class ValidPalindrome {
    public static void main(String[] args){
        System.out.println(new Solution().isPalindrome("aB -- B , a"));
        System.out.println(new Solution().isPalindrome("aBa"));
    }

    static class Solution {
        public boolean isPalindrome(String s) {
            s = s.toLowerCase();
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0; i < s.length(); i++){
                if (Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))){
                    stringBuilder.append(s.charAt(i));
                }
            }
            s = stringBuilder.toString();

            if (s.length() == 0) return true;
            for(int i = 0, j = s.length() - 1; i < j; i++,j--){
                if (s.charAt(i) != s.charAt(j)){
                    return false;
                }
            }
            return true;
        }
    }
}

