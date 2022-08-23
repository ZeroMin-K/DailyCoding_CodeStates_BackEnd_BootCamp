import java.util.*;
import java.util.stream.Collectors;

public class Q24IsSubsetOf {
    public boolean isSubsetOf(int[] base, int[] sample) {
        // 배열을 List로 변경
        List<Integer> intList
                = Arrays.stream(base)
                    .boxed()
                    .collect(Collectors.toList());

        // sample 순회하며
        for (int i : sample) {
            // List.contains 사용하여 포함 여부 검사
            if (!intList.contains(i)) {
                return false;
            }
        }
        return true;
    }
}
