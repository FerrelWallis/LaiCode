package cross_training3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArray_133 {
    //Merge K sorted array into one big sorted array in ascending order.
    //Assumptions: The input arrayOfArrays is not null, none of the arrays is null either.

    //k way merge 解题方法： k way all together (minheap)
    //1. 建立minheap，将k个array的第一个元素（最小元素）放入minheap
    //2. 每次弹出最小的元素，并将这个元素所在的array的下一个元素放入minheap
    public int[] merge(int[][] arrayOfArrays) {
        int k = arrayOfArrays.length;
        int len = 0;
        PriorityQueue<Element> minheap = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o1.value < o2.value ? -1 : 1;
            }
        });
        for (int i = 0; i < k; i++) { //O(k * logk)
            len += arrayOfArrays[i].length;
            if (arrayOfArrays[i].length > 0) {
                minheap.offer(new Element(i, 0, arrayOfArrays[i][0]));
            }
        }
        int[] asc = new int[k * len];
        for (int i = 0; i < k * len; i++) { //O(k*len*2logk)
            Element cur = minheap.poll();
            asc[i] = cur.value;
            if (cur.idxInArray < arrayOfArrays[cur.idxOfArray].length - 1) {
                minheap.add(new Element(cur.idxOfArray, cur.idxInArray + 1, arrayOfArrays[cur.idxOfArray][cur.idxInArray + 1]));
            }
        }
        return asc;
    }

    class Element {
        public int idxOfArray;
        public int idxInArray;
        public int value;
        public Element(int i, int j, int v) {
            idxOfArray = i;
            idxInArray = j;
            value = v;
        }
    }


}
