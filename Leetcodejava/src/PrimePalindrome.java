import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrimePalindrome {
    public static void main(String[] args){
        System.out.println(new Solution().primePalindrome(1000));
    }
}


class Solution {
    Queue<String> q = new PriorityQueue<>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            if (o1.isEmpty()){
                return -1;
            }
            if (o2.isEmpty()) return 1;
            System.out.println(o1+" "+o2);
            return Integer.parseInt(o1) - Integer.parseInt(o2);
        }
    });

    public int primePalindrome(int N) {
        q.add("");
        for (int i = 0; i <= 9; i++){
            q.add(i+"");
        }

        //start dequeuing
        do {
            String poll = q.poll();
            if (!poll.isEmpty() && Integer.parseInt(poll) >= 2 * 1000_000_00){
                continue;
            }
            if (poll.length() > 0){
                if (Integer.parseInt(poll) >= N && isPrime(poll)){
                    return Integer.parseInt(poll);
                }
            }
            for(int i = 0; i <= 9; i++){
                String added = i+poll+i;
                if (Integer.parseInt(added) <= 2 * 1000_000_00){
                    q.add(i+poll+i);
                }

            }
        } while (true);
    }

    public boolean isPrime(String s){
        return isPrime(Integer.parseInt(s));
    }

    public boolean isPrime(int N){
        if (N < 2) return false;
        for(int i = 2; i * i <= N; i++){
            if (N % i == 0) return false;
        }
        return true;
    }
}
