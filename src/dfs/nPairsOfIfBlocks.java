package dfs;

public class nPairsOfIfBlocks {
    //Given an integer n, print/output all possible ways of writing n pairs of if blocks with correct indentation.
    //
    //Say n=2 output should be
    //
    //
    //
    //if {
    //
    //}
    //
    //if {
    //
    //}
    //
    //<newline>
    //
    //if {
    //
    //  if {// here should exist two spaces before each inner block
    //
    //  }
    //
    //}

    //permutation dfs
    //是括号问题
    // 假设 left -> "if {"  right -> "}"  n = 2, left = 2, right = 2
    // 1. if (left <= right)  不能放right
    // 2. 当dfs base case left right都用完了 println  -> <newline>
    // 3. 每添加一个left 说明多一个innerblock， frontspace缩进空格数 + 2
    //    每添加一个right 说明少一个innerblock, frontspace缩进空格数 - 2；

    public static void main(String[] args) {
        nPairsOfIfBlocks test = new nPairsOfIfBlocks();
        test.printer(3);
//        System.out.println("xxx\n".length());
    }

    public void printer(int n) {
        StringBuilder sb = new StringBuilder();
        dfs(sb, 0, 0, 0, n);
    }

    public void dfs(StringBuilder sb, int left, int right, int frontspace, int n) {
        if (left == n && right == n) {
            System.out.println(sb.toString());
            System.out.println(); //2.
            return;
        }
        if (left < n) {
            for(int i = 0; i < frontspace; i++) {
                sb.append(" ");
            }
            sb.append("if {\n");
            dfs(sb,left + 1, right, frontspace + 2, n);
            sb.delete(sb.length() - 5 - frontspace, sb.length());
        }
        if (right < left) {  //1.
            for(int i = 0; i < frontspace - 2; i++) {
                sb.append(" ");
            }
            sb.append("}\n");
            dfs(sb, left, right + 1, frontspace - 2, n);
            sb.delete(sb.length() - 2 - (frontspace - 2), sb.length());
        }
    }

}
