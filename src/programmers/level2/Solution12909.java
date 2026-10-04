package programmers.level2;
import java.util.Deque;
import java.util.ArrayDeque;
public class Solution12909 {
    class Solution {
        boolean solution(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            for (int i = 0 ; i < s.length() ; i++) {
                char c = s.charAt(i);

                // 스택이 비어 있으면 push
                if(stack.isEmpty()){
                    stack.push(c);
                    continue;
                }

                // 스택 top 확인
                char top = stack.peek();

                if (top == ')') {
                    return false;
                } else {
                    if (c == ')') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }

            if (!stack.isEmpty()) {
                return false;
            }



            return true;
        }
    }
}
