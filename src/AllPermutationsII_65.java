import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AllPermutationsII_65 {
    public static void main(String[] args) {
        AllPermutationsII_65 test = new AllPermutationsII_65();
        List<String> ans = test.permutations("aba");
    }

    public List<String> permutations(String input) {
        List<String> ans = new ArrayList<>();
        if(input == null || input.length() == 0) {
            return ans;
        }
        dfs(ans, input.toCharArray(), 0);
        return ans;
    }

    private void dfs(List<String> ans, char[] input, int index) {
        if (index == input.length) {
            ans.add(new String(input));
            return;
        }
        HashSet<Character> used = new HashSet<>();
        for(int i = index; i < input.length; i++) {
            if (used.add(input[i])) {
                swap(input, index, i);
                dfs(ans, input, index + 1);
                swap(input, index, i);
            }
        }
    }

    private void swap(char[] input, int i, int j) {
        char tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }
}
