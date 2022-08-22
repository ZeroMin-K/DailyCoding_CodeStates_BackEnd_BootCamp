import java.util.ArrayList;

public class Q23Fibonacci {
    public int fibonacci(int num) {
        if (num <= 1) {
            return num;
        }

        return fibonacci(num - 1) + fibonacci(num - 2);
    }

    // dynamic with meoization: O(N)
    // 이미 해결한 문제 정답 따로 기록, 다시 해결하지 않는 기법
    // fibo(5)
    // = fibo(4) + fibo(3)
    // = fibo(3) + fibo(2) + fibo(2) + fibo(1)
    public int fibonacciRef(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);

        return fibo(list, num);
    }

    public int fibo(ArrayList<Integer> list, int num) {
        if(list.size() <= num) {
            list.add(fibo(list, num -1) + fibo(list, num-2));
        }
        return list.get(num);
    }
}
