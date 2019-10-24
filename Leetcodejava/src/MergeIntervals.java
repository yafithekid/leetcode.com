import java.lang.reflect.Array;
import java.util.*;

public class MergeIntervals {
    public static void main(String[] args){
        new MergeIntervals();
    }

    public MergeIntervals(){
        int[][] result = new Solution().merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        System.out.println(Arrays.deepToString(result));
    }

    class Solution {
        class Pair {
            public Pair(int a, int b) {
                this.a = a;
                this.b = b;
            }

            public int a,b;

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Pair pair = (Pair) o;
                return a == pair.a &&
                        b == pair.b;
            }

            public boolean intersect(Pair p){
                return (a <= p.a && p.a <= b) || (a <= p.b && p.b <= b);
            }

            public Pair merge(Pair p){
                return new Pair(Math.min(a, p.a),Math.max(b,p.b));
            }
        }

        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0){
                return intervals;
            }

            PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> {
                if (o1.a != o2.a){
                    return o1.a - o2.a;
                } else {
                    return o1.b - o2.b;
                }
            });
            for(int i = 0; i < intervals.length; i++){
                pq.add(new Pair(intervals[i][0],intervals[i][1]));
            }
            List<Pair> ret = new ArrayList<>();
            while (pq.size() >= 2){
                Pair first = pq.poll();
                Pair second = pq.poll();
                if (first.intersect(second)){
                    pq.add(first.merge(second));
                } else {
                    ret.add(first);
                    pq.add(second);
                }
            }
            ret.add(pq.poll());
            int[][] result = new int[ret.size()][];
            for(int i = 0; i < ret.size();i++){
                Pair pair = ret.get(i);
                result[i] = new int[]{pair.a,pair.b};
            }
            return result;

        }
    }
}
