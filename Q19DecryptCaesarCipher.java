public class Q19DecryptCaesarCipher {

    public static void main(String[] args) {
//        String output = decryptCaesarCipher("khoor", 3);
//        System.out.println(output); // --> hello

//        String output = decryptCaesarCipher("zruog", 3);
//        System.out.println(output); // --> world
//
    }

    public static String decryptCaesarCipher(String str, int secret) {
        // abcdefghijklmnopqrstuvwxyz
        // 복호화하기 위해 secret만큼 왼쪽으로 이동
        // 아스키코드를 이용한 이동
        // 빈문자열 입력시
        // 빈문자열 리턴
        if (str.length() == 0) {
            return "";
        }

        // 결과 빈 문자열
        // 문자열 하나씩 순회
        // 현재 문자열의 문자 + secret
        // 결과 문자열에 붙이기

        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            System.out.println("----------------");
            System.out.println("현재 문자: " + now);

            // 현재 문자가 공백이면 continue
            if (now ==' '){
                result = result + now;
                continue;
            }

            // 현재 문자와 a까지 길이
            int toStart = now - 'a';
            // 변환할 문자의 아스키 코드
            int convert;
            // secret 이동이 같거나 더 작으면
            if (secret <= toStart) {
                // secret만큼 이동
                System.out.println("secret만큼 이동 ");
                convert = (int) now - secret;
            }
            // secret 이동이 더 크면
            else {
                System.out.println("나머지 이동");

                // a까지 이동후 남은 이동 길이
                int rest = secret - toStart;
                // z에서부터 남은 이동길이로 이동

                System.out.println("rest " + rest);

                convert = 'z' - rest + 1;
                System.out.println("나머지 이동 후 " + (char) convert);
            }

            System.out.println("변환 문자: " + (char)convert);
            result = result + (char) convert;
        }

        // 결과 문자열 리턴
        return result;
    }

    public String decryptCaesarCipherRef(String str, int secret) {
        // 모든 알파벳 String으로 선언, 할당
        String alpha = "abcdefghijklmnopqrstuvwxyz";

        // 결과 담을 문자열 선언
        String result = "";

        //입력된 str만큼 순회
        for(int i = 0; i < str.length(); i++) {
            //해당 문자열이 공백일 경우
            if(str.charAt(i) == ' ') {
                // 결과 문자열에 공백 추가
                result = result + str.charAt(i);
            } else {
                // 알파벳 문자열 alpha에서 현재 문자열의 index 찾기
                int asis = alpha.indexOf(str.charAt(i));
                //복호화 진행 -  secret을 빼주기
                // 전체 길이를 더하고 나머지 구함 => 해당 문자열의 index 벗어날 경우 고려
                int tobe = (asis - secret + alpha.length()) % alpha.length();

                //복호화한 문자열을 result에 추가
                result = result + alpha.charAt(tobe);
            }
        }
        //복호화된 문자열 리턴
        return result;
    }
}
