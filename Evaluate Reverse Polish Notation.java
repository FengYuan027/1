public class Solution {
    /**
     * @param tokens The Reverse Polish Notation
     * @return the value
     */
    public int evalRPN(String[] tokens) {
        // Write your code here
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> ops = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if (isOperator(tokens[i])) {
                int op2 = ops.pop();
                int op1 = ops.pop();
                ops.push(calculate(op1, op2, tokens[i]));
            }
            else ops.push(Integer.parseInt(tokens[i]));
        }
        return ops.peek();
    }
    
    private boolean isOperator(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
    }
    
    private int calculate(int op1, int op2, String op) {
        if (op.equals("+")) return op1 + op2;
        else if (op.equals("-")) return op1 - op2;
        else if (op.equals("*")) return op1 * op2;
        else return op1/op2;
    }
}
