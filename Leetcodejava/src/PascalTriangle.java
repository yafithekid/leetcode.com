import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args){
        new PascalTriangle();
    }

    public PascalTriangle(){
        List<List<Integer>> generate = new Solution().generate(5);
        generate.forEach(System.out::println);
    }

    class Solution {

        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ret = new ArrayList<>();
            for(int i = 0; i < numRows; i++){
                List<Integer> numbers = new ArrayList<>();
                numbers.add(1);
                for(int j = 1; j <= i - 1; j++){
                    int x = ret.get(i - 1).get(j-1);
                    int y = ret.get(i - 1).get(j);
                    numbers.add(x + y);
                }
                if (i > 0){
                    numbers.add(1);
                }
                ret.add(numbers);
            }
            return ret;
        }
    }
}
