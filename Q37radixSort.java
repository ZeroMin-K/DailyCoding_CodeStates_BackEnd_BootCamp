public class Q37radixSort {
    public int[] radixSort(int[] arr) {
        // 최대값 계산
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
        }

        // 자릿수 기준으로 counting sort 이용하여 정렬
        for(int digit = 1; digit <= max; digit *= 10) {
            arr = countingSort(arr, digit);
        }

        return arr;
    }

    public int[] countingSort(int[] arr, int digit) {
        // 임시 배열
        int[] temp = new int[arr.length];
        // 카운팅 배열
        int[] countingArr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            // 해당 자리 수의 숫자 추출
            int num = (arr[i] / digit) % 10;
            countingArr[num]++;
        }

        // 누적합을 배열로 만듬
        for (int i = 1; i < countingArr.length; i++) {
            countingArr[i] += countingArr[i - 1];
        }

        /*
        배열의 가장 마지막 인덱스부터 시작
            가장 큰 수가 가장 뒤로 정렬
            안저적으로 정렬하기위해 마지막 요소부터 순회
         */
        for (int i = arr.length - 1; i >= 0; i--) {
            // 현재 배열의 자릿수 계산
            int num = (arr[i] / digit) % 10;
            // 해당 자릿수를 인덱스로 counting 배열의 요소 1씩 뺌
            countingArr[num]--;
            // 구한 값을 인덱스로 배열 요소를 삽입
            temp[countingArr[num]] = arr[i];
        }

        return temp;
    }
}
