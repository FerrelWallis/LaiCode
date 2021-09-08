import org.omg.CORBA.PUBLIC_MEMBER;

public class HexadecimalRepresentation_78 {
    //Generate the hexadecimal representation for a given non-negative integer number as a string. The hex representation should start with "0x".
    //
    //There should not be extra zeros on the left side.
    //
    //Examples
    //
    //0's hex representation is "0x0"
    //255's hex representation is "0xFF"

    //16进制 -> 2^4 即 每4位二进制 表示 1位16进制， int 一共32位
    //time O(1) space O(16)
    public String hex(int num) {
        char[] base = new char[]{'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        StringBuilder sb = new StringBuilder("0x");
        boolean isLeading = true;
        for(int i = 28; i >= 0; i -= 4) {
            char cur = base[(num >> i) & 0xf]; //0xf = 15
            if (cur != '0' || !isLeading) { //只有isLeading && cur == '0'的时候不操作，这里取反
                sb.append(cur);
                isLeading = false;
            }
        }
        return sb.toString();
    }


}
