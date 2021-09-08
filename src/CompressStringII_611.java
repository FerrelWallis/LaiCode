public class CompressStringII_611 {
    public String compress(String input) {
        if(input.length() == 0) {
            return input;
        }
        char[] in = input.toCharArray();
        return enode(in);
    }

    private String enode(char[] in) {
        //step 1: encode repeated letters
        int slow = 0;
        int fast = 0;
        int newlen = 0;
        while (fast < in.length) {
            int begin = fast;
            while (fast < in.length && in[fast] == in[begin]) {
                fast++;
            }
            in[slow++] = in[begin]; //从左往右，先字母再数字，因此可以先把字母放上
            if (fast - begin == 1) {
                newlen += 2;
            } else {
                int len = digit(in, slow, fast - begin);
                newlen += len + 1; //数字长度len + char 1
                slow += len;
            }
        }

        //step 2: resize
        char[] ans = new char[newlen];

        //step 3: compress single letters
        fast = slow - 1;
        slow = newlen - 1;
        while (fast >= 0) {
            //处理数字部分
            if (Character.isDigit(in[fast])) {
                while (fast >= 0 && Character.isDigit(in[fast])) {
                    ans[slow--] = in[fast--];
                }
            } else {
                ans[slow--] = '1';
            }
            //处理字母部分
            ans[slow--] = in[fast--];
        }
        return new String(ans);
    }

    private int digit(char[] in, int slow, int digit) {
        int len = 0;
        for (int i = digit; i > 0; i /= 10) {
            len++;
        }
        for (int i = len - 1; i >= 0 ; i--, digit /= 10) {
            in[slow + i] = (char) ('0' + digit % 10);
        }
        return len;
    }
}
