import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args){
        new TopKFrequentWords();
    }

    public TopKFrequentWords(){
        List<String> strings = new Solution().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
        System.out.println(strings);
    }

    class WordCount {
        String word;
        int count;

        public WordCount(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String,Integer> c = new HashMap<>();
            for (String word : words) {
                if (!c.containsKey(word)){
                    c.put(word,0);
                }
                c.put(word,c.get(word) + 1);
            }

            PriorityQueue<WordCount> pq = new PriorityQueue<>((o1, o2) -> {
                if (o1.count != o2.count){
                    return - (o1.count - o2.count);
                }
                return o1.word.compareTo(o2.word);
            });

            for (String key: c.keySet()) {
                pq.add(new WordCount(key,c.get(key)));
            }
            List<String> list = new ArrayList<>();
            while (k-- > 0){
                list.add(pq.poll().word);
            }
            return list;
        }
    }
}
