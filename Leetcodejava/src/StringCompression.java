public class StringCompression {
    public StringCompression(){
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c','c','c','d'};
        int compress = new Solution().compress(chars);
        System.out.println(compress);
        System.out.println(chars);
    }

    public static void main(String[] args){
        new StringCompression();
    }

    class Solution {
        public int compress(char[] chars) {
            if (chars.length <= 1) return chars.length;

            int counter = 1;
            char last = chars[0];
            int N = chars.length;
            int j = 0;
            for(int i = 1; i <= N; i++){
                if (i < N && last == chars[i]){
                    counter++;
                } else {
                    if (counter <= 1){
                        while (counter-- > 0){
                            chars[j++] = last;
                        }
                    } else {
                        chars[j++] = last;
                        String s = String.valueOf(counter);
                        for (char c : s.toCharArray()) {
                            chars[j++] = c;
                        }
                    }
                    if (i < N){
                        last = chars[i];
                        counter = 1;
                    }
                }
            }
            return j;
        }
    }
}
