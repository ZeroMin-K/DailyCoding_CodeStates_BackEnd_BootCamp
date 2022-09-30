public class Q37radixSortReview {
    public int[] radixSort(int[] arr) {
        // 최대값을 먼저 계산
        int maxValue = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(maxValue < arr[i]) {
                maxValue = arr[i];
            }
        }

        // countingSOrt를 사용하여 자릿수기준으로 정렬
        for(int digit = 1; digit <= maxValue; digit *= 10) {
            arr = countingSort(arr, digit);
        }

        return arr;
    }

    public int[] countingSort(int[] arr, int digit) {
        int[] temp = new int[arr.length];       // 임시로 사용할 공간
        int[] counting = new int[10];       // 카운팅 배열

        for (int i = 0; i < arr.length; i++) {
            int num = (arr[i] / digit) % 10;        // 해당 자리수의 숫자 추출
            counting[num]++;
        }

        // 누적합을 배열로 만듬
        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }

        // 배열의 가장 마지막 인덱스부터 시작
        // 가장 큰수가 가장 뒤로 정렬되어야 하기대문에
        // 안정적으로 정렬하기위해 마지막 요소부터 순회
        for (int i = arr.length - 1; i >= 0; i--) {
            // 현재 배열의 자릿수 계산
            int num = (arr[i] / digit) % 10;
            // 해당 자릿수를 인덱스로 coutning 배열의 요소를 1씩 뺌
            counting[num]--;
            // 구한 값을 인덱스로 counting 배열의 요소를 삽입
            temp[counting[num]] = arr[i];
        }

        // 해당 배열 반환
        return temp;
    }
}
