import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords_67 {

    //Given a composition with different kinds of words, return a list of the top K most frequent words in the
    // composition.
    //
    //Assumptions
    //
    //the composition is not null and is not guaranteed to be sorted
    //K >= 1 and K could be larger than the number of distinct words in the composition, in this case, just return all
    // the distinct words
    //Return
    //
    //a list of words ordered from most frequent one to least frequent one (the list could be of size K or smaller than K)
    //Examples
    //
    //Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 2 frequent words are [“b”, “c”]
    //Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 4 frequent words are [“b”, “c”, "a", "d"]
    //Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 5 frequent words are [“b”, “c”, "a", "d"]

    //1. hashmap进行word 记录
    //2. 遍历hashmap，建立minheap，
    public String[] topKFrequent(String[] combo, int k) {
        if (combo.length == 0) {
            return new String[0];
        }
        HashMap<String, Integer> map = countWords(combo);
        PriorityQueue<HashMap.Entry<String, Integer>> minheap = new PriorityQueue<>(new Comparator<HashMap.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (HashMap.Entry<String, Integer> m : map.entrySet()) {
            if (minheap.size() < k) {
                minheap.offer(m);
            } else if (minheap.peek().getValue() < m.getValue()) {
                minheap.poll();
                minheap.offer(m);
            }
        }
        String[] ans = new String[minheap.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = minheap.poll().getKey();
        }
        return ans;
    }

    private HashMap<String, Integer> countWords(String[] combo) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : combo) {
            Integer count = map.get(word);
            if (count == null) {
                map.put(word, 1);
            } else {
                map.put(word, count + 1);
            }
        }
        return map;
    }
}
