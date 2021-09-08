import java.util.Arrays;

public class StringReplacebasic_649 {
    public static void main(String[] args) {
        StringReplacebasic_649 test = new StringReplacebasic_649();
        String ans = test.replace("studentden", "den", "XXXX");
        String ans1 = test.replace("studentden", "den", "X");
        String ans2 = test.replace("denden", "denden", "X");
    }

    public String replace(String input, String source, String target) {
        if (input.length() < source.length()) {
           return input;
        }
        //step 1: find occurrence
        int count = findOccurrence(input, source, target);
        //step 2：resize
        char[] newinput = resize(input, source, target, count);
        //step 3: replace
        int start = replace(newinput, input, source, target);
        if(start < 0) {
            return new String(newinput);
        } else {
            //offset是指substring的start index，因此为start + 1
            return new String(newinput, start + 1, newinput.length - start - 1);
        }
    }

    public int replace(char[] newinput, String input, String source, String target) {
        int slow = newinput.length - 1;
        for (int fast = input.length() - 1; fast >= 0;) {
            int f = 0;
            while (fast >= source.length() - 1 && f < source.length() && newinput[fast - f] == source.charAt(source.length() - 1 - f)) {
                f++;
            }
            if (f == source.length()) { //找到了source
                for(int j = target.length() - 1; j >= 0; j--) { //将target放入
                    newinput[slow--] = target.charAt(j);
                }
                fast -= source.length();
            } else { //没找到
                newinput[slow--] = newinput[fast--];
            }
        }
        return slow;
    }

    private char[] resize(String input, String source, String target, int count) {
        if (source.length() >= target.length()) {
            return input.toCharArray();
        }
        int moreSize = count * (target.length() - source.length());
        char[] newinput = Arrays.copyOf(input.toCharArray(), input.length() + moreSize);
        return newinput;
    }


    private int findOccurrence(String input, String source, String target) {
        int count = 0;
        for (int i = 0; i <= input.length() - source.length(); i++) {
            int j = 0;
            while (j < source.length() && input.charAt(i + j) == source.charAt(j)) {
                j++;
            }
            if (j == source.length()) {
                count++;
            }
        }
        return count;
    }
}
