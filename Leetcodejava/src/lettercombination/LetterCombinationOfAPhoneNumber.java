package lettercombination;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfAPhoneNumber {
    public static void main(String[] args){
        List<String> strings = new Solution().letterCombinations("");
        System.out.println(strings);
    }
}

class Solution {
    static final String[] map = new String[]{
        "",
        "",
        "abc",
        "def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return new ArrayList<>();
        }

        List<String> ret = new ArrayList<>();
        rec(ret,"",digits,0);
        return ret;
    }

    void rec(List<String> result,String gen,String digits,int current){
        if (current == digits.length()){
            result.add(gen);
        } else {
            String mapped = map[Integer.parseInt(digits.charAt(current)+"")];
            for(int i = 0; i < mapped.length(); i++){
                rec(result,gen + mapped.charAt(i),digits,current+1);
            }
        }
    }
}
