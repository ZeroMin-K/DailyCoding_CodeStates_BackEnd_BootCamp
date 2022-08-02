public class Q10InsertDash {
    public String insertDash(String str) {

        // 빈문자열일때
        if (str.equals("")) {
            // null 반환
            return null;
        }

        // 결과 문자열 저장 - 빈문자열로 초기화
        String result = "";
        // 이전에 홀수가 나왔는지 체크
        boolean continuous = false;
        // 문자열 순회진행
        for(int i = 0; i < str.length(); i++) {
            // 현재 인덱스의 문자
            char now = str.charAt(i);
            // 현재 인덱스의 문자를 숫자로 변경
            int num = Character.getNumericValue(now);
            // 홀수이면
            if(now % 2 == 1) {
                // 이전에 홀수가 나왔으면
                if (continuous) {
                    // - 붙여서 결과문자열에 합침
                    result = result +  "-" + now;
                } // 이전에 홀수가 나오지 않았으면
                else {
                    // 그대로 문자열 붙이기
                    result += now;
                }
                // 현재 홀수가 나와서 홀수 체크
                continuous = true;
            } // 홀수가 아니면(짝수이면)
            else {
                // 결과 문자열에 그대로 합침
                result += now;
                // 짝수 등장 체크
                continuous = false;
            }
        }

        return result;
    }

    public String insertDashRef(String str) {
        // 빈문자열일때
        if(str.length() == 0) {
            // null 리턴
            return null;
        }

        // 결과 문자열에 현재 문자열의 첫번째 문자 삽입
        String result = "" + str.charAt(0);

        // 문자열을 1번째 인덱스부터 순회
        for(int i = 1; i < str.length(); i++) {
            // 직전 문자를 숫자로 바꾸어 2로 나머지 연산
            int preNumber = Character.getNumericValue(str.charAt(i-1)) % 2;
            // 현재 문자를 숫자로 바꾸어 2로 나머지 연산
            int curNumber = Character.getNumericValue(str.charAt(i)) % 2;

            // 직전 숫자, 현재 숫자 둘다 홀수 이면
            if(preNumber % 2 != 0 && curNumber % 2 != 0) {
                // 결과 문자열에 - 붙이기
                result = result + "-";
            }
            // 현재 숫자 결과문자열에 붙이기
            result = result + str.charAt(i);
        }
        return result;
    }

}
