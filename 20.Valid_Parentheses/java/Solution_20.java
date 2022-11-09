import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution_20 {


    public static void main(String[] args) {
        String s = "()";
        System.out.println("s ==>" + s
                + ", isValid ==>" + new Solution_20().isValid(s));
    }

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            if (stack.empty() || map.get(c) != stack.pop()) {
                return false;
            }
        }
        return stack.empty();
    }

}
