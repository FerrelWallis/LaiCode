public class AllUniqueCharactersII_77 {
    //Determine if the characters of a given string are all unique.
    //
    //Assumptions
    //
    //We are using ASCII charset, the value of valid characters are from 0 to 255
    //The given string is not null
    //Examples
    //
    //all the characters in "abA+\8" are unique
    //"abA+\a88" contains duplicate characters

    //方法一：255的数组
    public boolean allUnique(String word) {
        boolean[] visited = new boolean[255];
        for (int i = 0; i < word.length(); i++) {
            int cur = (int) word.charAt(i);
            if (visited[cur]) {
               return false;
            }
            visited[cur] = true;
        }
        return true;
    }

    //int数组 长度为8 用8个数字存储 1 int -> 32 bit  8 int -> 256 bit
    public boolean allUnique2(String word) {
        int[] visited = new int[8];
        for (int i = 0; i < word.length(); i++) {
            int cur = (int) word.charAt(i);
            int row = cur / 32;
            int col = cur % 32;
            if (((visited[row] >> col) & 1) != 0) {
                return false;
            }
            visited[row] |= (1 << col);
        }
        return true;
    }

}
