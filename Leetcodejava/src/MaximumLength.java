import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumLength {
    class Solution {
        public int maxLength(List<String> arr) {
            int N = arr.size();
            int maxlen = 0;
            System.out.println(1 << N);
            for(int comb = 0; comb < (1 << N); comb++){
                Set<Character> characters = new HashSet<>();
                int len = 0;
                for(int j = 0; j < N; j++){
                    if ((comb & (1 << j)) != 0){
//                        System.out.print(j);
                        len += arr.get(j).length();
                        for(char c: arr.get(j).toCharArray()){
                            if (characters.contains(c)){
                                len = -1; break;
                            } else {
                                characters.add(c);
                            }
                        }
                        if (len == -1) continue;
                    }
                }
                maxlen = Math.max(len,maxlen);
//                System.out.println();
            }
            return maxlen;
        }
    }

}
