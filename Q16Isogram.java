import java.util.*;

public class Q16Isogram {
    public boolean isIsogram(String str) {
        // isogram - 알파벳 한번씩만 이용해서 만든 단어나 문구
        // hashset이용해서 사용해서 구하면될듯
        // 대소문자 구별안함 => 전부 소문자로 바구기

        // 빈문자열 입력시
        if (str.length() == 0) {
            return true;
        }

        // 문자들 담을 hashset 생성
        HashSet<Character> hashSet = new HashSet<>();

        // 문자열 소문자로 바꾸기
        String result = str.toLowerCase();

        // 문자열 길이
        int len = result.length();

        // 문자열 순회하면서
        for(int i = 0; i < len; i++){
            // 현재 문자
            char now = result.charAt(i);

            // hashset에 이미 문자가 있으면
            if (hashSet.contains(now)) {
                // isogram이 아님
                return false;
            }

            // 현재 문자 hashset에 넣기
            hashSet.add(now);
        }

        // 문자열 순회하는 동안 문자가 다 한번씩만 있으면 isogram
        return true;
    }

    public boolean isIsogramRef(String str) {
        //입력된 문자열이 공백일 때
        if(str.length() == 0)
            // true리턴
            return true;

        //사용된 알파벳 저장할 HashMap 생성
        HashMap<Character, String> hashMap = new HashMap<Character, String>();

        //입력된 전체 문자열을 모두 소문자로 변환
        str = str.toLowerCase();

        //입력된 문자열 순회
        for(int i = 0; i < str.length(); i++) {
            //HashMap에 이미 해당 알파벳이 있으면
            if(hashMap.containsKey(str.charAt(i))) {
                //false 리턴
                return false;
            }
            //HashMap에 해당 문자열이 저장되어 있지 않으면 저장
            hashMap.put(str.charAt(i), "exists");
        }
        //모든 문자열을 순회한다면 true 리턴
        return true;
    }
}
