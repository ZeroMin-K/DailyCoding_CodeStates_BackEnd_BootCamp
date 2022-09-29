public class Q36InsertionSortReview {
    public int[] insertionSortRef(int[] arr) {
        for (int index = 1; index < arr.length; index++) {
            for (int target = index; target > 0; target--) {
                if(arr[target - 1] > arr[target]) {
                    int temp = arr[target - 1];
                    arr[target - 1] = arr[target];
                    arr[target] = target;
                }
            }
        }
        return arr;
    }
    /*
    최적화 적용한 코드
    - 삽입정렬에서 기존 정렬과정에서 이미 정렬이 이루어진 범위보다 큰수를 비교할경우
        이미 정렬한 숫자와 비교할 필요없음
        불필요한 과정을 줄일 수 있는 최적화 과정이 적용
     */

    public int[] optimizedInsertSortRef(int[] arr) {
        for (int index = 1; index < arr.length; index++) {
            int target = index;
            while (target > 0 && arr[target - 1] > arr[target]) {
                int temp = arr[target - 1];
                arr[target - 1] = arr[target];
                arr[target] = temp;
                target--;
            }
        }
        return arr;
    }
}
