import java.util.Stack;

public class Solution_232 {

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }


    static class Queue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;


        public Queue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            peek();
            return stack2.pop();
        }

        public int peek() {
            if (stack2.empty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        public boolean empty() {
            return stack1.empty() && stack2.empty();
        }
    }
}
