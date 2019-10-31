import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args){
        new SpiralMatrix();
    }
    public SpiralMatrix(){
        int[][] matrix = {{1, 2, 3 },{4,5,6},{7,8,9}};
        List<Integer> integers = new Solution().spiralOrder(matrix);
        System.out.println(integers);
    }
    class Solution {
        boolean[][] visited;
        public List<Integer> spiralOrder(int[][] matrix) {
            return spiralOrder(matrix,0,-1,0);
        }

        public List<Integer> spiralOrder(int[][] matrix,int i,int j,int direction) {
            if (matrix.length == 0){
                return new ArrayList<>();
            }
            int counter = 0, n = matrix.length, m = matrix[0].length;
            List<Integer> results = new ArrayList<>();
            visited = new boolean[n+1][m+1];
            do {
                if (direction == 0){ //right
                    if (j + 1 >= m || visited[i][j+1]){
                        direction++;
                        continue;
                    } else {
                        j += 1;
                    }
                } else if (direction == 1){ //down
                    if (i+1 >= n || visited[i+1][j]){
                        direction++;
                        continue;
                    } else {
                        i += 1;
                    }
                } else if (direction == 2){
                    if (j-1 < 0 || visited[i][j-1]){
                        direction++;
                        continue;
                    } else {
                        j -= 1;
                    }
                } else {
                    if (i - 1 < 0 || visited[i-1][j]){
                        direction = 0;
                        continue;
                    } else {
                        i -= 1;
                    }
                }
                results.add(matrix[i][j]);
                visited[i][j] = true;
                counter++;
            } while (counter < n * m);

            return results;

        }
    }
}
