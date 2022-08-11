public class Q18NumberSearch {
    public static int numberSearch(String str) {
        System.out.println("--------------------");
        // 빈문자열은
        // 0 리턴

        if (str.length() == 0) {
            return 0;
        }

        // 문자열 길이
        int len = str.length();

        // 숫자값들 더할 sum
        int sum = 0;

        // 문자열을 순회하며
        // 현재 문자가 숫자인지 확인
        // sum에 더함

        String numString = "0123456789";
        int rest = 0;
        for(int i = 0; i < len; i++) {
            String now = str.substring(i, i+1);
            System.out.println("현재 문자열 " + now);

            if (now.equals(" ")) {
                System.out.println("공백 패스 ");
                continue;
            }

            int num = numString.indexOf(now);
            if(num != -1) {
                sum += num;
            }
            else {
                rest++;
                System.out.println("나머지 문자열 증가" + now + " 나머지 문자열 개수 " + rest);
            }
        }

        System.out.println("숫자 총합 " + sum);
        System.out.println("나머지 길이 " + rest);

        // sum / 문자열길이 반올림하여 리턴
        return (int)Math.round((double) sum / rest);
    }

    public int numberSearchRef(String str) {
        // 0부터9까지 숫자 문자열 생성
        String digits = "0123456789";

        //입력된 문자열이 공백이면 0 리턴
        if(str.length() == 0)
            return 0;

        double sum = 0;         //  숫자 합산
        String pureStr = "";    // 숫자를 제외한 나머지 문자열 저장

        //문자열 순회
        for(int i = 0; i < str.length(); i++) {
            // digits의 값에서 str[i]의 값이 포함되는 확인
            // 값이 존재하면 해당 인덱스, 리턴 없으면 -1 리턴
            if(digits.indexOf(str.charAt(i)) != -1) {
                //숫자 더해줌
                sum = sum + Character.getNumericValue(str.charAt(i));
            }
            // 값이 존재하지 않고 공백이 아니면
            else if(str.charAt(i) != ' ') {
                // 해당 문자를 나머지 문자열에 붙이기
                pureStr = pureStr + str.charAt(i);
            }
        }
        // 숫자 합을 나머지 문자열의 길이로 나눔
        double result = sum / pureStr.length();
        //Math.round로 반올림하여 리턴
        return (int) Math.round((result * 10) / 10);
    }
}
