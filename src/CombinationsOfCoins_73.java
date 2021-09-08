import java.util.LinkedList;
import java.util.List;

public class CombinationsOfCoins_73 {
    public static void main(String[] args) {
        CombinationsOfCoins_73 test = new CombinationsOfCoins_73();
        List<List<Integer>> ans = test.combinations(10, new int[]{34,31,29,16,2});
    }

    public List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> ans = new LinkedList<>();
        if (target == 0) {
            return ans;
        }
        List<Integer> cur = new LinkedList<Integer>();
        combinations(ans, cur, coins, target, 0);
        return ans;
    }

    public void combinations(List<List<Integer>> ans, List<Integer> cur, int[] coins, int rem, int index) {
        if (index == coins.length) {
            if (rem == 0) {
                ans.add(cur);
            }
            return;
        }
        for (int i = 0; i <= rem / coins[index]; i++) {
            cur.add(i);
            combinations(ans, cur, coins, rem - i * coins[index], index + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
