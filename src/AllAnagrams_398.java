import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class AllAnagrams_398 {

    public static void main(String[] args) {
        AllAnagrams_398 test = new AllAnagrams_398();
        test.allAnagrams("ab","abcbac");
    }

    //1hashmap
    public List<Integer> allAnagrams(String sh, String lo) {
        List<Integer> ans = new ArrayList<>();
        if (lo.length() < sh.length()) {
            return ans;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int match = 0;
        countMap(map, sh);

        for (int i = 0; i < lo.length(); i++) {
            char ch = lo.charAt(i);
            Integer num = map.get(ch);
            if (num != null) {
                map.put(ch, num - 1);
                if (num == 1) {
                    match++;
                }
            }
            if (i >= sh.length()) {
                char head = lo.charAt(i - sh.length());
                Integer hnum = map.get(head);
                if (hnum != null) {
                    map.put(ch, hnum + 1);
                    if (hnum == 0) {
                        match--;
                    }
                }
            }
            if (match == map.size()) {
                ans.add(i);
            }
        }
        return ans;
    }

    private void countMap(HashMap<Character, Integer> map, String sh) {
        for (char ch : sh.toCharArray()) {
            Integer num = map.get(ch);
            if (num == null) {
               map.put(ch, 1);
            } else {
                map.put(ch, num + 1);
            }
        }
    }

    //2hashmap
    public List<Integer> allAnagrams2(String sh, String lo) {
        List<Integer> ans = new ArrayList<>();
        if (lo.length() == 0) {
            return ans;
        }
        HashMap<Character, Integer> shmap = new HashMap<>();
        loadMap(shmap, sh, sh.length());
        HashMap<Character, Integer> lomap = new HashMap<>();
        loadMap(lomap, lo, sh.length());
        if (checkMapEquals(shmap, lomap)) {
            ans.add(0);
        }
        int slow = 0;
        for (int i = sh.length(); i < lo.length(); i++) {
            Integer num = lomap.get(lo.charAt(slow));
            if (num == 1) {
                lomap.remove(lo.charAt(slow));
            } else {
                lomap.put(lo.charAt(slow), num - 1);
            }
            slow++;
            Integer num2 = lomap.get(lo.charAt(i));
            if (num2 == null) {
                lomap.put(lo.charAt(i), 1);
            } else {
                lomap.put(lo.charAt(i), num2 + 1);
            }
            if (checkMapEquals(shmap, lomap)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean checkMapEquals(HashMap<Character, Integer> shmap, HashMap<Character, Integer> lomap) {
        for (HashMap.Entry<Character, Integer> m : shmap.entrySet()) {
            Character ch = m.getKey();
            Integer num = m.getValue();
            if (!lomap.containsKey(ch) || !lomap.get(ch).equals(num)) {
                return false;
            }
        }
        return true;
    }

    private void loadMap(HashMap<Character, Integer> shmap, String input, int length) {
        for (int i = 0; i < length; i++) {
            if (!shmap.containsKey(input.charAt(i))) {
                shmap.put(input.charAt(i), 1);
            } else {
                int count = shmap.get(input.charAt(i));
                shmap.put(input.charAt(i), count + 1);
            }
        }
    }
}
