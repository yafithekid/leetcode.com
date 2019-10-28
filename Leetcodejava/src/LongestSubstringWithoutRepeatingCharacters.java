import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args){
        new LongestSubstringWithoutRepeatingCharacters();
    }

    LongestSubstringWithoutRepeatingCharacters(){
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
    }


    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s== null || s.length() == 0) return 0;

            int l = 0,r = 0,max = 1;
            Map<Character,Integer> last = new HashMap<>();
            last.put(s.charAt(0),0);

            for(r = 1; r < s.length(); r++){
                char current = s.charAt(r);
                if (last.containsKey(current)){
                    l = Math.max(last.get(current) + 1,l);
                }
                last.put(current,r);
//                System.out.println(l+ " " + r + " " +s.substring(l,r+1));
//                System.out.println(last);
                max = Math.max(max,r - l + 1);
            }
            return max;
        }
    }
}
