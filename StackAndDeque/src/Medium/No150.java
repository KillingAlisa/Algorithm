package Medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class No150 {
    public static void main(String[] args) {
        String s = "+-*/";
        String s1 = "=";
        String s2 = "+";
        System.out.println(s.contains(s1));
        System.out.println(s.contains(s2));
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();
        String expression = "+-*/";
        for (int i = 0; i < tokens.length; i++) {
            if (expression.contains(tokens[i])) {
                int rightNum = deque.pop();
                int leftNum = deque.pop();
                switch (tokens[i]) {
                    case "+" :
                        deque.push(leftNum + rightNum);
                        break;
                    case "-" :
                        deque.push(leftNum - rightNum);
                        break;
                    case "*" :
                        deque.push(leftNum * rightNum);
                        break;
                    case "/" :
                        deque.push(leftNum / rightNum);
                        break;
                }
            } else {
                deque.push(Integer.parseInt(tokens[i]));
            }
        }
        return deque.pop();
    }
}
