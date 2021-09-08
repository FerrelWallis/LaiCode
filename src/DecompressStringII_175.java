public class DecompressStringII_175 {
    public String decompress(String input) {
        int newlen = 0;
        int i = 1;
        while (i < input.length()) {
            int sum = input.charAt(i++) - '0';
            while (i < input.length() && Character.isDigit(input.charAt(i))) {
                sum = sum * 10 + (input.charAt(i++) - '0');
            }
            newlen += sum;
            i++;
        }
        char[] ans = new char[newlen];
        i = 0;
        int cur = 0;
        while (i < input.length()) {
            char letter = input.charAt(i++);
            int num = input.charAt(i++);
            while (i < input.length() && Character.isDigit(input.charAt(i))) {
                num = num * 10 + (input.charAt(i++) - '0');
            }
            for (int j = 0; j < num; j++) {
                ans[cur++] = letter;
            }
        }
        return new String(ans);
    }

}
