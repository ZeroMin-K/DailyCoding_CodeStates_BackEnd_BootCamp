import java.util.ArrayList;
import java.util.Arrays;

public class Q29tiling {
    public int tiling(int num) {
        // 위 가로든 아래가로든 가로로 하나를 배치하게되면 무조건 하나는 같이 배치됨
        // 가로 길이만큼의 배열을 생성해서 경우의수를 기록
        // 가로 길이가 1일 때 1가지
        // 가로길이가 2일 때 = (1일때 + 세로 더한거) + 가로로 두개  = 1 + 1
        // 가로길이가 3일 때 = (2일 때 + 세로 더한거) + (1일때 가로로 두개) =

        // 가로길이가 1이면
        if (num == 1)
            // 한가지 경우의수 밖에 없음
            return 1;

        // 해당 가로길이 일때 경우의수 저장하는 배열
        int[] dp = new int[num+1];

        // 가로길이 1, 2일 때 값 넣기
        dp[1] = 1;
        dp[2] = 2;

        // num까지 숫자를 진행하면서
        // 현재 가로길이 일 때 경우의수는 (현재 가로길이-1) 경우의수 + (현재 가로길이 -2) 경우의수
        for(int i = 3; i <= num; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        // num일때 경우의수 return
        return dp[num];
    }

    // 재귀 이용 - O(2^N)
    public int tilingRef1(int num) {
        if (num <= 2)
            return num;
        return tiling(num - 1) + tiling(num - 2);
    }

    public int tilingRef2(int num) {
        // 인덱스를 직관적으로 관리하기위해
        // 앞 부분에 더미 데이터 채움
        ArrayList<Integer>  memo = new ArrayList<>(Arrays.asList(0, 1, 2));
        return solve(num, memo);
    }

    public int solve(int size, ArrayList<Integer> memo) {
        // 이미 해결한 문제는 풀지 않음
        if (memo.size() > size)
            return memo.get(size);

        memo.add(solve(size -1, memo) + solve(size-2, memo));
        return memo.get(size);
    }
}
