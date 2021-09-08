package dfs;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations_404 {
    //Given an integer number, return all possible combinations of the factors that can multiply to the target number.

    //Example: Give A = 24
    //since 24 = 2 x 2 x 2 x 3
    //              = 2 x 2 x 6
    //              = 2 x 3 x 4
    //              = 2 x 12
    //              = 3 x 8
    //              = 4 x 6
    //your solution should return

    //{ { 2, 2, 2, 3 }, { 2, 2, 6 }, { 2, 3, 4 }, { 2, 12 }, { 3, 8 }, { 4, 6 } }
    //note: duplicate combination is not allowed.

    //1. preprocess 找出target的在所有factor
    //2. 99cent probelm
    //假设target有n个factors， 则levels有 n levels， branches？ remain中最多可以有多少个factor

    public List<List<Integer>> combinations(int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (target <= 1) {
            return ans;
        }
        //1. preprocess
        List<Integer> factors = new ArrayList<>();
        for (int i = target / 2; i > 1; i--) {
            if (target % i == 0) {
                factors.add(i);
            }
        }
        //99cent
        List<Integer> cur = new ArrayList<>();
        dfs(ans, cur, factors, target, 0);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, List<Integer> cur, List<Integer> factors, int remains, int index) {
        if (index == factors.size()) {
            if(remains == 1) {
                ans.add(new ArrayList<>(cur));
            }
            return;
        }
        //0个当前fac的情况直接drill down
        dfs(ans, cur, factors, remains, index + 1);
        int fac = factors.get(index);
        int cursize = cur.size(); // 帮助恢复之前的状态，后面要吐的时候用
        while (remains % fac == 0) {
            cur.add(fac);
            remains /= fac;
            dfs(ans, cur, factors, remains, index + 1);
        }
        cur.subList(cursize, cur.size()).clear();
    }



}
