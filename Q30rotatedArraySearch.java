public class Q30rotatedArraySearch {
    public int rotatedArraySearch(int[] rotated, int target) {
        // O(N) Solution - 순차탐색
        //   int len = rotated.length;
        //   for(int i = 0; i < len; i++) {
        //     if (rotated[i] == target) {
        //       return i;
        //     }
        //   }
        //   return -1;
        // }

        // O(logN) Solution - 이진 탐색 이용
        int len = rotated.length;

        int start = 0;
        int end = rotated.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (rotated[mid] == target) {
                return mid;
            }

            if (rotated[mid] < target) {
                if (rotated[end] < target) {
                    end = mid - 1;
                }
                else
                    start = mid + 1;

            }
            else {
                if (rotated[start] > target) {
                    start = mid + 1;
                }
                else
                    end = mid - 1;
            }
        }

        return -1;
    }

    public int rotatedArraySearchRef(int[] rotated, int target) {
        int left = 0;
        int right = rotated.length -1;

        while (left <= right) {
            int mid = (right + left) / 2;

            if(rotated[mid] == target) {
                return mid;
            }

            // 왼쪽부분이 정렬된 상태인 경우
            // 왼쪽 인덱스의 숫자와 중간 인덱스의 숫자가 오름차순 => 정렬
            if (rotated[left] < rotated[mid]) {
                // left 인덱스 숫자 < = target <= mid 인덱스의  숫자 일때
                // left, target, mid가 순차적일 때
                if (rotated[left] <= target && target < rotated[mid]) {
                    // 왼쪽 부분에서 탐색
                    right = mid - 1;
                } else {    // left, target, mid가 순차적이지 않을때
                    // 오른쪽 부분 탐색
                    left = mid + 1;
                }
            }
            // 오른쪽 부분이 정렬된 상태인 경우
            else {
                // mid 인덱스의 숫자 <= target <= right 인덱스의 숫자
                // mid, target, right가 순차적일 때
                if(rotated[mid] < target && target <= rotated[right]) {
                    // 오른쪽 부분에서 탐색
                    left = mid + 1;
                } else {    // mid, target, right가 순차적이지 않을 때
                    // 왼쪽 부분 탐색
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
