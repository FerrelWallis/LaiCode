package sorting;

public class SelectionSort_4 {
    public int[] solve(int[] array) {
        //5 2 4 8 13 9
        //(           )
        //2 (5 4 8 13 9)
        //2 4 (5 8 13 9)
        //2 4 5 ( 8 13 9)
        //2 4 5 8 9 (13)
        //until one ele in the range
        if (array == null || array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
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
