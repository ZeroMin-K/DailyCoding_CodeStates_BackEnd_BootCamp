public class Q22BubbleSortReview {
    public int[] swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;

        return arr;
    }

    public int[] bubbleSort(int[] arr) {
        int arrLength = arr.length;

        for(int i = 0; i < arrLength - 1; i++) {
            for (int j= 0; j < arrLength -1; j++) {
                if( arr[j] > arr[j+1]) {
                    arr = swap(arr, j, j+1);
                }
            }
        }

        return arr;
    }

    public int[] bubbleSortOptimized(int[] arr) {
        int arrLength = arr.length;

        for(int i = 0; i < arrLength; i++) {
            // swaps 횟수 기록
            // 어떤 요소도 swap되지 않으면 배열은 정렬된 상태
            int swaps = 0;

            for (int j = 0; j < arrLength - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swaps++;
                    arr = swap(arr, j, j = 1);
                }
            }

            if (swaps == 0) {
                break;
            }
        }

        return arr;
    }
}
