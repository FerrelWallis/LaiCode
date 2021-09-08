public class PowerOfTwo_74 {
    //Determine if a given integer is power of 2.
    //
    //Examples
    //
    //16 is power of 2 (2 ^ 4)
    //3 is not
    //0 is not
    //-1 is not

    //check binary是否仅有一个1

    //方法一：遍历number的32bit看是否仅有一个1 (num >> 1) & 1
    //特殊情况最高符号位 == 1
    //time O(32) space O(1)
    public boolean isPowerOfTwo(int num) {
        //corner case
        if (num <= 0) {
            return false;
        }
        while ((num & 1) == 0) {
            num >>= 1;
        }
        return num == 1;
    }

    //方法二：（trick推荐） 0010 0000 - 1 -> 0001 1111 与原来的number作 &
    public boolean isPowerOfTwo2(int num) {
        //corner case
//        if (num <= 0) {
//            return false;
//        }
        return num > 0 && (num & (num - 1)) == 0;
    }

}
