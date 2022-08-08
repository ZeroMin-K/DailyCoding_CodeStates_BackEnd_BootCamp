public class Q14superIncreasing {
    public boolean superIncreasing(int[] arr) {

        // 빈 배열 일때
        if (arr.length == 0) {
            return false;
        }

        // 맨 첫번째 원소를 이전 요소들의 합에 저장
        int sum = arr[0];
        // 두번째 원소부터 순회 진행
        for (int i = 1; i < arr.length; i++) {
            // 현재 원소가 이전 요소들의 합보다 작으면(같은것도 포함)
            if( arr[i] <= sum) {
                return false;
            }
            // 현재 원소를 이전 요소들의 합에 더함
            sum += arr[i];
        }

        // 중간에 return 안하고 그대로 for문 순회완료
        // 모든 원소가 이전 요소들의 합보다 큼
        return true;
    }
}
