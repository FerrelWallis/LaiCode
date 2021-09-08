public class RemoveSpaces_281 {
    //Given a string, remove all leading/trailing/duplicated empty spaces.
    //
    //Assumptions:
    //
    //The given string is not null.
    //Examples:
    //
    //“  a” --> “a”
    //“   I     love MTV ” --> “I love MTV”

    //挡板思想
    public String removeSpaces(String input) {

        char[] in = input.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < in.length; fast++) {
            if (in[fast] == ' ' && (slow == 0 || in[slow - 1] == ' ')) {
                continue;
            }
            in[slow++] = in[fast];
        }
        if (slow > 0 && in[slow - 1] == ' ') {
            slow--;
        }
        return new String(in, 0, slow);
    }
}
