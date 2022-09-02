import java.util.*;

public class Q31powerSet {
    public ArrayList<String> powerSet(String str) {
        // 정렬
        String pureStr = removeDuple(str);
        Stack<String> stack = new Stack<>();

        ArrayList<String> result = new ArrayList<>();

        result = combination(stack, 0, pureStr, result);

        // 오름차순 정렬
        Collections.sort(result);

        return result;
    }

    // 중복 제거
    public String removeDuple(String str) {
        String result = "";

        // indexOf로 중복여부 확인
        for(int index = 0; index < str.length(); index++) {
            if(str.indexOf(str.charAt(index)) == index) {
                result += str.charAt(index);
            }
        }

        String[] sorted = result.split("");
        Arrays.sort(sorted);
        result = String.join(",", sorted).replaceAll(",", "");
        return result;
    }
    // 모든 조합 검사
    public ArrayList<String> combination(Stack<String> stack, int idx,
                                         String subset, ArrayList<String> result){

        // 탈출 조건
        // idx가 subset의 길이보다 같거나 크다면 (마지막까지 검토한 경우)
        if (idx >= subset.length()) {
            // 스택을 문자열로 변환 후 result에 넣어줌
            result.add(stack.toString()
                        .replaceAll("\\[", "")
                        .replaceAll("]", "")
                        .replaceAll(",", "")
                        .replaceAll(" ", ""));
        } else {
            // idx가 부분집합에 포함된 경우
            stack.push(Character.toString(subset.charAt(idx)));
            combination(stack, idx + 1, subset, result);

            // idx가 부분집합에 포함되지 않은 경우
            stack.pop();
            combination(stack, idx + 1, subset, result);
        }
        return result;
    }
}
