import java.util.*;
import java.util.Map.Entry;

public class Q28balancedBrackets {
    // 첫 풀이 - 정확한 괄호 값을 if문에서 확인
    public boolean balancedBrackets(String str) {
        /*
         스택에다 괄호 넣으면서 괄호짝 맞는지 진행
         짝이 맞으면 팝
         최종적으로 스택이 비어있으면 짝이 맞는것
         비어있지 않으면 짝이 맞지 않는 것
         */

        // 빈 문자열일 경우
        if (str.length() == 0)
            // true 리턴
            return true;

        // 해시맵 생성- <Character, Character>
        HashMap<Character, Character> hashMap = new HashMap<>();
        // 해시맵에 ), ( 추가
        hashMap.put(')', '(');
        // 해시맵에 }, { 추가
        hashMap.put('}', '{');
        // 해시맵에 ], [ 추가
        hashMap.put(']', '[');

        // 비어있는 스택 생성
        Stack<Character> stack = new Stack<>();

        // 문자열을 순회하며
        // 현재 문자

        // 현재 문자가 (, {, [ 이면
        // 스택에 넣기
        // 현재 문자가 ), {, [ 이면
        // 스택에서 피크한 값과 현재 문자를 해시맵에 넣은 값과 같으면
        // 스택 팝

        int len = str.length();
        // 문자열 순회하면서
        for (int i = 0; i < len; i++) {
            // 현재 괄호
            char now = str.charAt(i);

            // 현재 괄호가 (, {, [ 이면
            if (now == '(' || now == '{' || now == '[')
                // 스택에 넣기
                stack.push(now);
            // 현재 괄호가 ), }, [이면
            else if (now == ')' || now == '}' || now == ']') {
                // 현재 스택이 비어있으면
                if (stack.empty())
                    // 괄호 짝이 안맞아서 false return
                    return false;

                // 현재 괄호 키에 대한 value 반대 괄호가 스택 peek값과 같으면
                if (hashMap.get(now) == stack.peek()) {
                    // 스택 팝
                    stack.pop();
                }
            }
        }

        // 스택이 비어있으면
        if (stack.empty())
            // true 리턴
            return true;
            // 아니면
        else
            // false 리턴
            return false;
    }

    // 두번째 풀이 - hashMap 추가 활용
    public boolean balancedBrackets2(String str) {
        /**
         스택에다 괄호 넣으면서 괄호짝 맞는지 진행
         짝이 맞으면 팝
         최종적으로 스택이 비어있으면 짝이 맞는것
         비어있지 않으면 짝이 맞지 않는 것
         */

        // 빈 문자열일 경우
        if (str.length() == 0)
            // true 리턴
            return true;

        // 해시맵 생성- <Character, Character>
        HashMap<Character, Character> hashMap = new HashMap<>();
        // 해시맵에 ), ( 추가
        hashMap.put(')', '(');
        // 해시맵에 }, { 추가
        hashMap.put('}', '{');
        // 해시맵에 ], [ 추가
        hashMap.put(']', '[');

        // 비어있는 스택 생성
        Stack<Character> stack = new Stack<>();

        // 문자열을 순회하며
        // 현재 문자

        // 현재 문자가 (, {, [ 이면
        // 스택에 넣기
        // 현재 문자가 ), {, [ 이면
        // 스택에서 피크한 값과 현재 문자를 해시맵에 넣은 값과 같으면
        // 스택 팝

        int len = str.length();
        // 문자열 순회하며
        for (int i = 0; i < len; i++) {
            // 현재 괄호
            char now = str.charAt(i);

            // hashMap에 대한 Entry Set 생성하여 순회하며
            for (Entry<Character, Character> entry : hashMap.entrySet()){
                // 현재 괄호가 entry의 value 같으면 (entry의 값은 왼쪽괄호)
                if (now == entry.getValue()) {
                    // 스택에 push
                    stack.push(now);
                }
                // 현재 괄호가 entry의 key와 같으면 (entry의 key는 오른쪽 괄호)
                else if (now == entry.getKey()) {
                    // 만약 스택이 비어있으면
                    if(stack.empty())
                        // 짝이 안맞아서 false return
                        return false;

                    // 현재 괄호를 key로 hashMap의 값(왼쪽 괄호)과 stack의 peek값이 같으면
                    if (hashMap.get(now) == stack.peek())
                        // 짝이 맞아서 스택에서 pop
                        stack.pop();
                }
            }
        }

        // 스택이 비어있으면
        if (stack.empty())
            // true 리턴
            return true;
            // 아니면
        else
            // false 리턴
            return false;

    }

    public boolean balancedBracketsRef(String str) {
        // 스택 사용 
        Stack<Character> stack = new Stack<>();
        
        // HashMap 선언, 쌍이 맞는 괄호를 키와 값으로 할당 
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('{', '}');
        hashMap.put('[', ']');
        hashMap.put('(', ')');

        // 괄호의 뒷부분을 따로 String으로 선언
        String rightBrackets = "}])";

        // 문자열 순회하면서 
        for(int i = 0; i < str.length(); i++) {
            
            // 현재 문자가 왼쪽 괄호일 경우 (hashMap에 해당 문자열의 키가 존재하는 경우)
            if(hashMap.containsKey(str.charAt(i))) {
                //스택에 해당 괄호 삽입
                stack.push(str.charAt(i));
                
            // 현재 문자가 오른쪽 괄호이고 (rightBracket에 해당 괄호가 존재하는 경우) and
            // 스택이 비어있지 않은 경우
            } else if(rightBrackets.indexOf(str.charAt(i)) != -1 && stack.size() > 0) {
                
                // 스택에서 꺼낸 괄호 
                char top = stack.pop();
                // 스택에서 꺼낸 괄호와 매칭되는 괄호  
                char pair = hashMap.get(top);
                
                // 매칭되는 괄호와 비교한 값이 다르다면 
                if(pair != str.charAt(i)) {
                    // false 리턴 
                    return false;
                }
            // 그 외의 경우
            // (스택이 비어있고, 현재 문자가 오른쪽 괄호 인 경우)  
            } else {
                // false 리턴
                return false;
            }
        }
        // 스택이 비면 true, 비어있지 않으면 false 리턴
        return stack.size() == 0;
    }
}