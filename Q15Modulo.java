public class Q15Modulo {
    public Integer modulo(int num1, int num2) {

        // 0으로 나누는 경우
        if (num2 == 0) {
            return null;
        }

        // 몇번 곱하는지
        int count = 0;
        // num2 * count해서 num1보다 작은 동안
        while ( num1 >= num2 * count) {
            count++;
        }
        // 마지막으로 1을 더해서 다시 빼주기
        count--;

        return  num1 - (num2 * count);

    }

    public Integer moduloRef(int num1, int num2) {
        if(num2 == 0) {
            return null;
        }

        while (num1 >= num2) {
            num1 = num1 - num2;
        }

        return num1;
    }
}
