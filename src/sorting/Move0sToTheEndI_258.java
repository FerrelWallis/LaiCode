package sorting;

public class Move0sToTheEndI_258 {

    //i = 0 j = len - 1
    // 1. [0, i) : all ele != 0
    // 2. [i, j] : ele waiting to be explored
    // 3. (j, len-1] : ele == 0
    // i > j
    public int[] moveZero(int[] array) {
        int i = 0;
        int j = array.length - 1;
        while (i <= j) {
            if (array[i] != 0) {
                i++;
            } else if (array[j] == 0) {
                j--;
            } else {
                swap(array, i++, j--);
            }
        }
        return array;
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
