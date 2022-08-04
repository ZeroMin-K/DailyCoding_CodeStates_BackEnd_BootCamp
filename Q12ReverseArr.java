import java.util.*;

public class Q12ReverseArr {
    public static int[] reverseArr(int[] arr) {
        // 재귀를 이용해 뒤집기
        // 결과 - 뒤집힌 배열 반환
        // 뒤집힌 배열은 결국 마지막원소를 앞에서부터 차례대로 뒤집는것
        // 현재 배열은 이미 뒤집혀있는 상태에서 마지막원소만 앞으로 빼내기

        // 배열 길이가 0일 때
        if(arr.length == 0)
            // 빈배열 리턴
            return new int[]{};

        // 결과 배열 맨앞에 합칠 arr의 맨 마지막 원소
        int[] head = Arrays.copyOfRange(arr, arr.length-1, arr.length);
        // 결과 배열 뒤에 합칠 arr에서 앞에서부터 맨 마지막을 제외한 원소
        int[] tail = reverseArr(Arrays.copyOfRange(arr, 0, arr.length-1));

        // 결과 배열
        int[] result = new int[head.length + tail.length];
        // 결과 배열 맨앞에 arr의 맨마지막 원소 head 복사
        System.arraycopy(head, 0, result, 0, head.length);
        // 결과 배열 뒤에 arr의 나머지 배열들 tail 복사
        System.arraycopy(tail, 0, result, head.length, tail.length);
        return result;
    }
}
