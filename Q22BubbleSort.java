public class Q22BubbleSort {
    public int [] swap(int idx1, int idx2, int[] arr) {
        // 두 변수 교환
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;

        // XOR 연산 활용
        // arr이 reference type이라 가능
        // arr[idx1] ^= arr[idx2];
        // arr[idx2] ^= arr[idx1];
        // arr[idx1] ^= arr[idx2];

        return arr;
    }

    public int[] bubbleSort(int[] arr) {
        int arrLength = arr.length;

        for (int i = 0; i < arrLength -1; i++) {
            // 매 반복마다 i번째로 큰 수가 마지막에서 i번째 위치
            // 이미 정렬된 요소는 고려할 필요 없음. j < n - 1 -i만 비교
            for (int j = 0; j < arrLength -1; j++) {
                if(arr[j] > arr[j+1]) {
                    arr = swap(j, j+1, arr);
                }
            }
        }

        return arr;
    }

    // optimized Solution
    public int[] bubbleSortOptimized(int[] arr) {
        int arrLength = arr.length;

        for (int i =0; i < arrLength; i++) {
            // swap 횟수 기록
            // 어떤 요소도 swap되지 않은 경우 배열은 정렬된 상태
            int swaps = 0;

            // 매 반복마다 i번째로 큰 수가 마지막에서 i번째 위치
            // 이미 정렬된 요소는 고려할 필요 없음 j < n - 1 -i 만비교
            for(int j = 0; j < arrLength -1; j++) {
                if (arr[j] > arr[j+1]) {
                    swaps++;
                    arr = swap(j, j+1, arr);
                }
            }

            if (swaps == 0) {
                break;
            }
        }
        return arr;
    }
}
