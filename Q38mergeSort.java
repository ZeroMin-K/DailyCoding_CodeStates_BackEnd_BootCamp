public class Q38mergeSort {
    public int[] mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    public void sort(int[] arr, int left, int right) {
        if (left < right) {
            // 가운데 인덱스 계산
            int mid = (left + right) / 2;

            // 배열 중앙을 기준으로 2개 그룹으로 분할
            sort(arr, left, mid);
            sort(arr, mid + 1, right);

            // 병합
            merge(arr, left, mid, right);
        }
    }

    public void merge(int[] arr, int left, int mid, int right) {
        // 임시 배열 선언
        int[] temp = new int[arr.length];
        // 임시 배열에 기존 arr 배열 복사
        System.arraycopy(arr, 0, temp, 0, arr.length);

        // 좌측 배열 시작 인덱스
        int leftIndex = left;
        //우측 배열 시작 인덱스
        int rightIndex = mid + 1;
        // 정렬된 값을 병합된 배열에 넣을 인덱스
        int index = left;

        // 좌측 배열, 우측 배열 두 배열 중 한 쪽 요소가 모두 없어질때까지 반복
        while(leftIndex <= mid && rightIndex <= right) {
            if(temp[leftIndex] <= temp[rightIndex]) {
                arr[index++] = temp[leftIndex++];
            }
            else {
                arr[index++] = temp[rightIndex++];
            }
        }

        // 좌측 배열의 요소가 남았을 경우 남은 요소 넣어줌
        // 오른쪽 배열 원소가 남는 경우 따로 처리 불필요
        for(int i = 0; i <= mid - leftIndex; i++) {
            arr[index + i] = temp[leftIndex + i];
        }
    }
}
