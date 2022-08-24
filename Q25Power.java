import java.util.*;

public class Q25Power {
    public long power(int base, int exponent) {
        // exponent가 짝수이면
        // exponent의 절반으로 두번 곱하면 현재 exponent
        // exponent가 홀 수 이면
        // exponent의 절반으로 두번 곱하고 base한번더 곱하면 현재 exponent

        final long div = 94906249;

        if (exponent == 0) {
            return 1;
        }

        Stack<Integer> stack = new Stack<>();

        while (exponent > 1) {
            if (exponent % 2 == 0) {
                stack.push(base);
                exponent /= 2;
            }
            else {
                stack.push(1);
                exponent--;
            }
        }

        long pow = base;

        while (!stack.empty()) {
            int now = stack.pop();

            if (now == 1) {
                pow = (pow * base) % div;
            }
            else {
                pow = (pow * pow) % div;
            }
        }
        return pow;
    }

    public long powerRef(int base, int exponent) {
        // 재귀 함수로 동작
        // exponent변수가 0이 될때까지 재귀 돈후 나머지 연산 계산
        // 해당 결과값을 사용하여 홀 수 일 경우 다시 연산하여 리턴

        if (exponent == 0)
            return 1;

        int half = exponent / 2;
        long temp =powerRef(base, half);
        long result = (temp * temp) % 94906249;

        if(exponent % 2 == 1)
            return (base * result) % 94906249;
        else
            return result;
    }
}
