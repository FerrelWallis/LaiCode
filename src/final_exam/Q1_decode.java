package final_exam;

import java.util.ArrayList;
import java.util.List;

public class Q1_decode {
    //Q1. Find all possible decode ways.
    //The decoding scheme is:
    //1 -> A
    //2 -> B
    //…
    //10 -> J
    //11 -> K
    //12 -> L
    //…
    //21 -> U
    //22 -> V
    //...
    //26 -> Z
    //e.g. Given input String  "1121"
    //It can be decoded as
    //[ "AABA",
    //  "AAU",
    //  "ALA",
    //  "KBA",
    //  "KU"
    //]
    //return all the possible decode ways, or just print out all decodes ways



    //条件
    //case 1: 1 ~ 9  单个0不行
    //case 2: 10 ~ 26 二位数 第一位是1 第二位只能是0~9
    //                             2 第二位稚只能是0~6

    //1122
    //        1   A
    //11  1|1  AA   OR  11 K
    //112 DP1|12 OR DP11|2
    //            1122 DP112|2  OR 11|22
    //只与前一个 和 前两个有关

    //方法2：dfs subset问题
    //要么加密一个数字，要么加密两个数字
    public List<String> decode2(String input) {
        if (input == null || input.length() == 0) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] in = input.toCharArray();
        helper(ans, sb, in, 0);
        return ans;
    }

    private void helper(List<String> ans, StringBuilder sb, char[] in, int index) {
        if (index == in.length) {
            ans.add(sb.toString());
            return;
        }
        int first = in[index] - '0';
        int second = in[index + 1] - '0';
        int sum = first * 10 + second;
        if (first >= 1 && first <= 9) {
            sb.append('A' + first - 1);
            helper(ans, sb, in, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (sum >= 10 && sum <= 26) {
            sb.append('A' + sum - 1);
            helper(ans, sb, in, index + 2);
            sb.delete(sb.length() - 2, sb.length());
        }
    }


    //方法一： dp思想 string的处理存在问题，不好搞，时间空间复杂度双高
    public List<String> decode(String in) {
        List<String> pre = new ArrayList<>();
        List<String> prepre = new ArrayList<>();
        //初始化 prepre 仅有第一个元素时
        //初始化 prepre 仅有第一第二个元素时
        for(int i = 0; i < in.length(); i++) {
            List<String> cur = new ArrayList<>();
//            if() {//最后一个元素 valid可加密
//                //把pre的元素都拿出来后面加上加密的新元素,并加入cur
//                //cur.add()
//            }
//            if(最后两个元素 valid) {
//                //把prepre的元素拿出来后面加上新元素并加入cur
//            }
            prepre = pre;
            pre = cur;
        }
        return pre;
    }
}
