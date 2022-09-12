public class Q36insertionSort {

    public int[] insertionSortRef(int[] arr) {
        for (int index = 1; index < arr.length; index++) {
            for (int target = index; target > 0; target--) {
                if (arr[target - 1] > arr[target]) {
                    int temp = arr[target -1];
                    arr[target - 1] = arr[target];
                    arr[target] = temp;
                }
            }
        }

        return arr;
    }

    public int[] optimizedInsertionSortRef(int[] arr) {
        for (int index = 1; index < arr.length; index++) {
            int target = index;
            while (target > 0 && arr[target - 1] > arr[target]) {
                int temp = arr[target - 1];
                arr[target - 1] = arr[target];
                arr[target]= temp;
                target--;
            }
        }

        return arr;
    }

}
