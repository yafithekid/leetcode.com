import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    class Solution {
        Map<Character,Integer> position = new HashMap<>();

        public int firstUniqChar(String s) {
            for(char c = 'a'; c <= 'z'; c++){
                position.put(c,-1);
            }
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if (position.get(c) == -1){
                    position.put(c,i);
                } else {
                    position.put(c,-2);
                }
//                System.out.println(i+" "+c+" "+position.get(c));

            }
            int min = -1;
            for(char c = 'a'; c <= 'z'; c++){
                if (position.get(c) >= 0){
                    if (min == -1){
                        min = position.get(c);
                    } else {
                        min = Math.min(min,position.get(c));
                    }

                }
            }
            return min;
        }
    }
}
