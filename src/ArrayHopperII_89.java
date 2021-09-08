public class ArrayHopperII_89 {


    //M[i] 表示当前位置跳到end的最小步数
    //base case: M[array.length - 1] = 0
    //induction rule: A[i] = k   M[i] = 1 + min(M[i + 1], M[i + 2],..., M[i + k])

    public int minJump(int[] array) {
        int[] M = new int[array.length];
        for (int i = array.length - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; i + j < array.length && j <= array[i]; j++) {
                min = Math.min(min, M[i + j]);
            }
            M[i] = min == Integer.MAX_VALUE? Integer.MAX_VALUE : min + 1;
        }
        return M[0] == Integer.MAX_VALUE? -1 : M[0];
    }

}
