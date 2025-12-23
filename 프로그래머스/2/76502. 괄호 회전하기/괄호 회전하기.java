import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Queue<Character> q = initQueue(s);
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            for (char ch : q) {
                if (!stack.isEmpty() && (
                    (stack.peek() == '(' && ch == ')') ||
                    (stack.peek() == '[' && ch == ']') ||
                    (stack.peek() == '{' && ch == '}'))) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
            
            if (stack.isEmpty()) answer++;
            stack.clear();
            q.offer(q.poll());
        }
        return answer;
    }
    
    private Queue<Character> initQueue(String s) {
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            q.offer(s.charAt(i));
        }
        return q;
    }
}