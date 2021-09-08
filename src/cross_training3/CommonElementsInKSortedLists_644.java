package cross_training3;

import java.util.ArrayList;
import java.util.List;

public class CommonElementsInKSortedLists_644 {
    //Find all common elements in K sorted lists.
    //Assumptions: The input and its elements are not null, and support fast random access.
    //There could be duplicate elements in each of the lists.

    //Examples: Input = {{1, 2, 2, 3}, {2, 2, 3, 5}, {2, 2, 4}}, the common elements are {2, 2}.

    //两两进行 谁小移谁
    public List<Integer> commonElementsInKSortedArrays(List<List<Integer>> kLists) {
        int k = kLists.size();
        List<Integer> ans = kLists.get(0);
        for(int i = 1; i < k; i++) {
            if (ans.size() == 0) {
                break;
            }
            ans = compareList(ans, kLists.get(i));
        }
        return ans;
    }

    private List<Integer> compareList(List<Integer> a, List<Integer> b) {
        List<Integer> ans = new ArrayList<>();
        int pa = 0;
        int pb = 0;
        while (pa < a.size() && pb < b.size()) {
            if (a.get(pa) == b.get(pb)) {
                ans.add(a.get(pa));
                pa++;
                pb++;
            } else if(a.get(pa) < b.get(pb)) {
                pa++;
            } else {
                pb++;
            }
        }
        return ans;
    }

}
