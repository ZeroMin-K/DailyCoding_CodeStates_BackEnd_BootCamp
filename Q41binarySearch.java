public class Q41binarySearch {
    public int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            else if (arr[mid] < target) {
                start = mid + 1;
            }
            else
                end = mid - 1;
        }

        return -1;
    }

    public int binarySearchRef(int[] arr, int target) {
        // 좌측 기준점
        int left = 0;

        // 우측 기준점
        int right = arr.length - 1;

        // 기준점이 서로 도달할때까지 반복
        while (left <= right) {
            // 중앙 기준점
             int mid = (right + left) / 2;
             // 현재 기준이 타겟과 일치시
            if (arr[mid] == target)
                return mid;         // 반환
            // 기준점 보다 크면
            if (target < arr[mid]) {
                // 우측 기준점 변경
                right = mid - 1;
            // 기준점보다 작으면
            } else {
                // 좌측 기준점 변경
                left = mid + 1;
            }
        }
        return -1;
    }
}
