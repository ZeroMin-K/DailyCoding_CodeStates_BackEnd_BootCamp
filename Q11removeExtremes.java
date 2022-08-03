import java.util.*;

public class Q11removeExtremes {
    public static String[] removeExtremes(String[] arr) {

        // 공백을 입력받은 경우
        // null 반환
        if (arr.length == 0) {
            return null;
        }

        // 가장 짧은 문자열, 가장 긴 문자열이 다수 일경우 나중에 위치한 문자열 제거
        // 가장 짧은 문자열찾기
        // 가장 긴 문자열 찾기
        // 가장 짧은 문자열이 다수일때 나중에 위치한 문자열 제거
        // 가장 긴 문자열이 다수 일때 나중에 위치한 문자열 제거

        // 가장짧은 문자열, 가장 긴 문자열 제거한 결과 문자열 리스트
        ArrayList<String> strList = new ArrayList<>();
        // 문자열 배열의 값을 문자열리스트에 삽입
        for(String str: arr) {
            strList.add(str);
        }

        // 가장 긴 문자열 길이
        int max = 0;
        // 가장 짧은    문자열 길이
        int min = 21;

        // 가장 긴 문자열들의 인덱스 저장용 리스트
        ArrayList<Integer> maxIndexList = new ArrayList<>();
        // 가장 짧은 문자열들의 인덱스 저장용 리스트
        ArrayList<Integer> minIndexList = new ArrayList<>();

        // 문자열 배열의 길이
        int len = arr.length;
        // 문자열 배열 순회
        for(int i = 0; i < len; i++) {
            // 현재 문자열의 길이
            int now = arr[i].length();
            // max보다 크면
            if(now >= max) {
                // max 갱신
                max = now;
            }
            // min보다 작으면
            if(now <= min) {
                // min 갱신
                min = now;
            }
        }

        // 문자열 배열 탐색하면서 가장 짧은 문자열, 가장 긴 문자열 개수 확인
        for(int i = 0; i < len; i++) {
            // 현재 문자열의 길이
            int now = arr[i].length();
            // 가장 긴 문자열 길이랑 같은 것들
            if(now == max) {
                // maxIndexList에 추가
                maxIndexList.add(i);
            }
            // 가장 짧은 문자열 길이랑 같은 것들
            if (now == min) {
                // minIndexList에 추가
                minIndexList.add(i);
            }
        }

        // 나중에 위치한 문자열을 제거하기 위해
        // 가장 긴문자열의 인덱스리스트 정렬
        Collections.sort(maxIndexList);
        // 가장 짧은 문자열 인덱스 리스트 정렬
        Collections.sort(minIndexList);

        // 가장 긴 문자열인덱스 중 가장 뒤 인덱스에 해당하는 문자열을 결과 리스트에서 제거
        // 가장 긴 문자열 인덱스 중 가장 뒤 인덱스
        int maxLastIndex = maxIndexList.get(maxIndexList.size() -1);
        // 가장 긴 문자열 인덱스 중 가장 뒤 인덱스의 문자열
        String maxLastStr = strList.get(maxLastIndex);

        // 가장 짧은 문자열 인덱스 중 가장 뒤 인덱스에 해당하는 문자열을 결과 리스트에서 제거
        int minLastIndex = minIndexList.get(minIndexList.size() -1);
        // 가장 짧은 문자열 인덱스 중 가장 뒤 인덱스의 문자열
        String minLastStr = strList.get(minLastIndex);

        // 가장 긴 문자열 중 가장 뒤에 있는 문자열 제거
        strList.remove(maxLastStr);
        // 가장 짧은 문자열 중 가장 뒤에 있는 문자열 제거
        strList.remove(minLastStr);

        // 결과리스트를 새로운 배열에 삽입
        String[] newArr = new String[strList.size()];
        for(int i = 0; i < newArr.length; i++) {
            newArr[i] = strList.get(i);
        }

        return newArr;
    }

    public String[] removeExtremesRef(String[] arr) {
        //입력된 문자열이 공백일때 null을 리턴
        if(arr.length == 0) {
            return null;
        }

        // 문자열의 최대길이 20, 최소 길이 0
        int shortestLen = 20;       // 가장 짧은길이 - 20으로 초기화
        int longestLen = 0;         // 가장 긴 길이 - 0으로 초기화
        int shortestIdx = 0;        // 가장 짧은 문자열의 인덱스
        int longestIdx = 0;         // 가장 긴 문자열의 인덱스

        //배열 길이 만큼 순회
        for (int i = 0; i < arr.length; i++) {
            // 현재 문자열이 longestLen보다 클때
            if (arr[i].length() >= longestLen) {
                //longestLen에 현재 문자열 길이 저장
                longestLen = arr[i].length();
                // longestIdx에 현재 문자열인덱스 저장
                longestIdx = i;
            }
            // 현재 문자열이 shortestLen보다 작을때
            if (arr[i].length() <= shortestLen) {
                // shortedLen에 현재 문자열 길이 저장
                shortestLen = arr[i].length();
                // shortestIdx에 현재 문자열 인덱스 저장
                shortestIdx = i;
            }
        }
        // 결과 저장할 새로운 배열 생성
        //  최소 문자열과 최대 문자열 제외 =>  -2만큼의 배열 생성
        String[] result = new String[arr.length - 2];

        int curIndex = 0;
        //배열 순회 결과를 넣어준 후
        for (int i = 0; i < arr.length; i++) {
            // 가장 짧은 문자열, 가장 긴 문자열의 인덱스가 아닐때
            if (i != shortestIdx && i != longestIdx) {
                // 결과 배열에 저장
                result[curIndex] = arr[i];
                curIndex++;
            }
        }
        //결과 리턴
        return result;
    }

}
