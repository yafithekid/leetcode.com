import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FractionToDecimal {
    public FractionToDecimal(){
        String s = new Solution().fractionToDecimal(-1,-2147483648);
        System.out.println(s);
    }
    public static void main(String[] args){
        new FractionToDecimal();
    }
    class Solution {
        public String fractionToDecimal(int numerator, int denominator){
            return fractionToDecimal2(numerator,denominator);
        }

        public String fractionToDecimal2(long numerator, long denominator) {
            if (numerator == 0){
                return "0";
            }
            if (numerator < 0 || denominator < 0){
                if ((numerator < 0) ^ (denominator < 0)){
                    return "-" + fractionToDecimal2(Math.abs(numerator),Math.abs(denominator));
                } else {
                    return fractionToDecimal2(Math.abs(numerator),Math.abs(denominator));
                }

            }
            StringBuilder result = new StringBuilder();
            result.append(numerator/denominator);
            if (numerator % denominator > 0){
                numerator %= denominator;
                result.append(".");
            } else {
                return result.toString();
            }

            while (numerator * 10 < denominator){
                numerator *= 10;
                result.append("0");
            }
            List<Long> appended = new ArrayList<>();

            Map<Long,Integer> visited = new HashMap<>();
            int counter = 0;
            while (numerator > 0){
                if (visited.containsKey(numerator)){
                    int location = visited.get(numerator);
                    for(int i = 0; i < location; i++){
                        result.append(appended.get(i));
                    }
                    result.append("(");
                    for(int i = location; i < appended.size(); i++){
                        result.append(appended.get(i));
                    }
                    result.append(")");
                    break;
                } else {
                    visited.put(numerator,counter++);
                    appended.add((numerator * 10) / denominator);
                    numerator = (numerator * 10) % denominator;

                }

            }
            if (numerator == 0){
                for(long a: appended){
                    result.append(a);
                }
            }
            return result.toString();
        }
    }


}
