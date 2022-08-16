public class Q20CompressString {
    public String compressString(String str) {
        // 연속구간을 반복되는 수와 문자로 조합한 형태로 문자열 압축
        // 3개 이상 연속되는 문자만 압축하기

        // 결과 문자열
        String result = "" ;
        // 빈문자열일때 빈문자열 리턴
        if (str.length() == 0) {
            return result;
        }

        // 이전문자 저장
        char prev = str.charAt(0);

        // 나타나는 횟수 count
        int count = 0;

        // 문자열 하나씩 순회
        // 현재 문자
        // 현재문자와 이전문자가 다르면
        // count가 3이상이면
        // count을 결과 문자열에 붙이기
        // 이전문자 결과 문자열에 붙이기
        // count = 0
        // count 증가
        // 이전문자는 현재문자

        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            if(prev != now) {
                if (count >= 3) {
                    result = result + count;
                }
                else if (count == 2) {
                    result = result + prev;
                }
                result = result + prev;
                count = 0;
            }
            count++;
            prev = now;
        }

        // 마지막 문자 추가
        if (count >= 3) {
            result = result + count;
        }
        while (count >= 1) {
            result = result + prev;
            count--;
        }

        // 결과 문자열 리턴
        return result;
    }

    public String compressStringRef(String str) {
        // 빈문자열 입력시 빈문자열 리턴
        if(str.length() == 0) 
            return "";
        // 연속되는 문자 기록 변수 선언
        char before = str.charAt(0);        // 첫번째 문자로 초기화 
        // 동일한 문자 반복 횟수 저장 변수 선언
        int count = 1;      // 초기값 1
        // 결과 문자열 선언 
        String result = "";     // 초기값 공백

        // 마지막 부분이 연속된 문자일 경우 dummy 문자 추가
        str = str + ' ';
        for (int i = 1; i < str.length(); i++) {
            // 동일한 문자 반복시 
            if (before == str.charAt(i)) {
                //count 증가
                count++;
            } 
            else {
                // 이전과 다른 문자 경우 
                // 반복된 횟수가 3 이상일 때  문자열 압축
                if (count >= 3) {   
                    result = result + count + before;
                } else {
                    //count 수만큼 결과 문자열에 저장
                    for(int j = 0; j < count; j++) {
                        result = result + before;
                    }
                    //자바 11에서 지원하는 String.repeat메소드 활용시 간단하게 작성 가능
                    //result = result + Character.toString(before).repeat(count);
                }
                // 현재 문자가 이전문자로 초기화
                before = str.charAt(i);
                // 반복 횟수 1로 초기화
                count = 1;
            }
        }
        return result;
    }
}
