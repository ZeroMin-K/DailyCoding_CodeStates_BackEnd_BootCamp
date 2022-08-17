import java.util.*;

public class Q21LargestProductOfThree {
    public static int largestProductOfThree(int[] arr) {
        // TODO:
        // arr : 중첩되지 않은 1차원 배열 - 음수, 0을 포함하는 정수, 배열의 길이 3이상
        // 곱해서 최대값이 되려면 0 제외
        // 음수를 곱하려면 무조건 두개 곱하기
        // 나올수 있는 조합 - 음수 두개 * 양수, 양수 3개
        // 가장 작은 음수 두개 => 곱하면 나머지 음수 곱한것보다 큼

        // arr 정렬
        // arr[0], arr[1]이 둘다 음수이면
        // arr[0] * arr[1] * arr[마지막]과 arr[마지막]에서 3개곱 비교


        // -----
        // i,j, k 각각 arr순회하면서 max찾기
        int max = -9999;
        for(int i = 0; i < arr.length; i++){
            for (int j = i+1; j < arr.length; j++) {
                for(int k = 0; k < arr.length; k++) {
                    if(i == j && j == k && k == j){
                        continue;
                    }
                    int result = arr[i] * arr[j] * arr[k];
                    if (max < result) {
                        max = result;
                    }
                }
            }
        }

        return max;
    }

    public int largestProductOfThreeRef(int[] arr) {
        // 배열 오름차순 정렬
        Arrays.sort(arr);
        
        int arrLength = arr.length;
        
        //가장 큰 양수 3가지 곱한 값
        int candidate1 = arr[arrLength - 1] * arr[arrLength - 2] * arr[arrLength - 3];
        
        //가장 작은 음수 2개, 가장 큰 양수 곱한 값
        int candidate2 = arr[arrLength - 1] * arr[0] * arr[1];
        
        // 두가지중 가장 큰 값 리턴
        return Math.max(candidate1, candidate2);
    }
}
