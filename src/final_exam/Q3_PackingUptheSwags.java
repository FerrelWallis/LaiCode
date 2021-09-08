package final_exam;

public class Q3_PackingUptheSwags {
    //Our company is going to distribute swags at the recruiting event. We will put the swags into square-shaped boxes. Each box has to be completely filled so that the swags wouldn’t break during transportation. For example, a box can contain 1 swag, 4 swags, 9 swags, etc. (The boxes can be sufficiently large.)
    //
    //However, if there are 10 swags, we have to put them into multiple boxes. For example, we could split them into four boxes:
    //
    //Or maybe just two boxes are enough:
    //
    //Given the number of swags, what is the minimum number of boxes to pack them up?
    //Example #1
    //Input: 4
    //Output: 1 (just one 2x2 box)
    //Example #2
    //Input: 10
    //Output: 2 (one 3x3 box and one 1x1 box)

    //左大段右小段问题（dp）
    //time O(n^1.5) spcae O(n)
    public int swag(int boxes) {
        if(boxes == 0) {
            return 0;
        }
        int[] dp = new int[boxes + 1];
        dp[0] = 0;
        //dp[i]表示装i个stuff最少用到的箱子数量
        for (int i = 1; i <= boxes; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j * j <= i; j++) { // 左大段
                min = Math.min(min, dp[i - j * j] + 1);
            }
            dp[i] = min;
        }
        return dp[boxes];
    }





}
