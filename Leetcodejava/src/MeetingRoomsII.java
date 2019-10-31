import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public static void main(String[] args){
        new MeetingRoomsII();
    }

    public MeetingRoomsII(){
        int i = new Solution().minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}});
        System.out.println(i);
    }

    class Pair {
        public int a;
        public int b;
        public boolean inRoom = false;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }

    class Solution {
        public int minMeetingRooms(int[][] intervals) {
            List<Pair> input = new ArrayList<>();
            for(int i = 0; i < intervals.length; i++){
                input.add(new Pair(intervals[i][0],intervals[i][1] -1));
            }
            input.sort(Comparator.comparingInt(o -> o.a));

            int result = 0;
            PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.b));
            for (Pair pair : input) {


                while (pq.size() > 0 && pq.peek().b < pair.a){
                    pq.poll();
                }

                pq.add(pair);
                System.out.println(pq.size());
                result = Math.max(pq.size(),result);
            }
            return result;
        }
    }

}
