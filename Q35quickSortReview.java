public class Q35quickSortReview {
    public int[] quickSort(int[] arr) {
        // 빈 배열일 경우
        if (arr.length == 0) {
            return arr;
        }

        int left = 0;
        int right = arr.length - 1;

        return sort(arr, left, right);
    }

    private int[] sort(int[] arr, int left, int right) {
        // partition
        int part = partition(arr, left, right);

        if (left < part - 1)
            arr = sort(arr, left, part - 1);
        if (right > part)
            arr = sort(arr, part, right);

        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        // 배열 중앙 기준
        int pivot = arr[(left + right) / 2];

        // 좌측이 우측보다 작을 경우 (아직 모든 배열 순회하지 않은 경우)
        while (left <= right) {
            // 좌측 인덱스 수가 기준점보다 작다면
            while (arr[left] < pivot)
                // 좌측 인덱스 증가
                left++;

            // 우측 인덱스 수가 기준점보다 크다면
            while (arr[right] > pivot)
                // 우측 인덱스 감소
                right--;

            // 우측 인덱스가 좌측 인덱스보다 크거나 같다면
            if (left <= right) {
                // 좌측 인덱스의 수와 우측 인덱스의 수 교환
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                // 좌측 인덱스 증가
                left++;
                // 우측 인덱스 증가
                right--;
            }
        }

        return left;
    }
}
