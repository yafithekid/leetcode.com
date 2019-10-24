import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class ValidAnagram {
    class Solution {
        public boolean isAnagram(String s, String t) {
            char[] sc = s.toCharArray();
            char[] tc = t.toCharArray();
            Arrays.sort(sc);
            Arrays.sort(tc);
            if (sc.length != tc.length) return false;
            for(int i = 0; i < sc.length; i++){
                if (sc[i] != tc[i]) return false;
            }
            return true;
        }
    }
}
