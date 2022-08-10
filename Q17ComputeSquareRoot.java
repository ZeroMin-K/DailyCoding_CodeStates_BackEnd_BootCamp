public class Q17ComputeSquareRoot {
    public String computeSquareRoot(int num) {

        // 제곱근 값으로 만들기 - 소수점 두자리까지로 (소수점 셋째 자리에서 반올림)
        // 문자열로 변환하기
        // String.format("%2.f", 변환할 시킬 수)
        int precision = 10;     // 정밀도 - 임의의 자연수
        double x = precision;

        // 바빌로니아 법 점화식을 이용하여 제곱근 구하기
        for(int i = 0; i < precision; i++) {
            x = 0.5 * (num / x + x);
        }

        // 제곱근 소수점 둘째자리 구해서 문자열로 변환
        return String.format("%.2f", x);
    }

    public String computeSquareRootRef(int num) {
        // 소수점 3자리부터 반올림 => 배열에 소수점 자리만큼 double 값 할당
        double[] diffs = new double[]{1, 0.1, 0.01, 0.001};
        //초기값을 1로 설정합니다.
        // 초기값 1로 설정
        double base = 1;

        // 배열 순회
        for(int i = 0; i < diffs.length; i++) {
            //초기값을 곱했을때, 입력된 값보다 작다면
            // 초기값을 곱했을 때 입력된 값보다 작으면
            while (base * base < num) {
                // 기본값에 소수점 초기값 더함
                base = base + diffs[i];
            }
            // 모두 더한 값이 입력된  num과 일치시 (더이상 낮은 숫자 비교할 필요 없는 경우)
            if(base * base == num) {
                // 소수점 2자리까지 값을 String값으로 변환, 리턴
                return String.format("%.2f", base);
            }else {
                // 기본 값에서 현재 배열의 인자 제외
                // 배열의 인자가 바뀌어 while문이 정상적으로 순회 가능
                base = base - diffs[i];
            }
        }
        //소수점 2자리까지의 값을 String값으로 변환, 리턴
        return String.format("%.2f", base);
    }
}
