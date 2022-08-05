import java.util.*;
public class Q13ReadVertically {

    public String readVertically(String[] arr) {
        // 가장 긴 문자열 길이 탐색
        int maxLength = 0;
        for(int i = 0; i < arr.length; i++) {
            if(maxLength < arr[i].length()) {
                maxLength = arr[i].length();
            }
        }

        // 가장 긴 문자열 길이 만큼 임시 배열 생성
        String[] temp = new String[maxLength];
        // 기존 배열 순회
        for(int i = 0; i < arr.length; i++) {
            // 기존 배열의 원소 - 문자열
            String str = arr[i];
            for(int j = 0; j < str.length(); j++) {
                // 임시 배열이 있엇으면
                if (temp[j] == null) {
                    // 문자열 j번재 char를 String으로 변환후 삽입 (세로 위치 첫문자열)
                    temp[j] = Character.toString(str.charAt(j));
                }
                // 임시배열이 비어있지 않으면 임시 배열의 기존 문자열에 현재 j번째 char더해줌
                else {
                    temp[j] = temp[j] + str.charAt(j);
                }
            }
        }

        // 배열 순회하며 String으로 변환
        String result = "";
        for(int i = 0; i < temp.length; i++) {
            result = result + temp[i];
        }

        return result;
    }
}
