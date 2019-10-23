import java.util.*;

public class GenerateParentheses {
    public static void main(String[] args){
        System.out.println(new Solution().generateParenthesis(3));
    }

    static class Solution {
        static List<List<String>> result = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            return generateParenthesis2(n * 2);
        }

        public List<String> generateParenthesis2(int n){
            List<String> result = new ArrayList<>();
            gen(result,"",0,n);
            return result;
        }

        public void generate(int n){
            if (n == 2) {
                return;
            } else {
                generate(n-2);
                List<String> buff = new ArrayList<>();
                List<String> iterated = result.get(n-2);
                for(String s: iterated){
                    buff.add("("+s+")");
                }
                for(String s: iterated){
                    buff.add("()"+s);
                }
                result.set(n,buff);
            }
        }

        public void gen(List<String> result,String buff,int open,int n){
            if (buff.length() == n){
                result.add(buff);
            }
            if (n - buff.length() > (open + 1)){
                gen(result, buff + "(", open + 1, n);
            }
            if (open > 0){
                gen(result,buff + ")",open - 1, n);
            }
        }
    }
}
