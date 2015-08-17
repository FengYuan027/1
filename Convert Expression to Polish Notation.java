public class Solution {
    /**
     * @param expression: A string array
     * @return: The Polish notation of this expression
     */
    public ArrayList<String> convertToPN(String[] expression) {
        // write your code here
        ArrayList<String> reversed = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
        for (int i = expression.length - 1; i >= 0; i--) {
            String exp = expression[i];
            if (isOperator(exp)) {
                if (exp.equals(")")) {
                    stack.push(exp);
                }
                else if (exp.equals("(")) {
                    while (!stack.peek().equals(")")) {
                        reversed.add(stack.pop());
                    }
                    stack.pop();
                }
                else {
                    while (!stack.empty() && order(exp) < order(stack.peek())) {
                        reversed.add(stack.pop());
                    }
                    stack.push(exp);
                }
            }
            else {
                reversed.add(exp);
            }
        }
        while (!stack.empty()) {
            reversed.add(stack.pop());
        }
        Collections.reverse(reversed);
        return reversed;
    }
    
    public boolean isOperator(String exp) {
        return exp.equals("+") || exp.equals("-") || exp.equals("*") || exp.equals("/") || exp.equals("(") || exp.equals(")");
    }
    
    public int order(String exp) {
        if (exp.equals("*") || exp.equals("/")) {
            return 2;
        }
        else if (exp.equals("+") || exp.equals("-")) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
